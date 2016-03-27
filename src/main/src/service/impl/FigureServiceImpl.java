package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import main.src.dao.CategoryDao;
import main.src.dao.FigureDao;
import main.src.entity.gallery.Nation;
import main.src.entity.gallery.State;
import main.src.entity.gallery.item.Figure;
import main.src.service.FigureService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("figureService")
@Transactional
public class FigureServiceImpl implements FigureService {
	
	@Resource(name = "figureDaoHibernate4")
	private FigureDao figureDao;
	
	public FigureServiceImpl() {
	}

	public int save(Figure figure) {
		if(StringUtils.isNotEmpty(figure.getName())){
		Figure o = get(figure.getName());
		if(o == null){
			return figureDao.save(figure);
		}else{
			return o.getId();
		}
		}else{
			return 0;
		}
	}
	@Override
	public void persist(Figure figure) {
		figureDao.persist(figure);
	}
	
	@Override
	public void delete(int id) {
		Figure n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Figure figure) {
		figureDao.delete(figure);
	}
	@Override
	public void update(Figure figure) {
		figureDao.update(figure);
	}
	@Override
	public Figure remove(int id) {
		Figure figure = get(id);
		return figure;
	}

	@Override
	public Figure get(int id) {
		return figureDao.get(id);
	}
	@Override
	public Figure get(String name) {
		String hql ="from Figure where name=:name";
		Session s = figureDao.getSession();
		Figure figure = (Figure)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return figure;
	}

	@Override
	public void recover(int id) {
	}

	public FigureDao getFigureDao() {
		return figureDao;
	}

	public void setFigureDao(FigureDao figuredao) {
		this.figureDao = figuredao;
	}

	public static List<String> getDomains() {
		String hql ="select f.domain from Figure f group by f.domain ORDER BY count(*) DESC";
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		FigureDao figureDao = (FigureDao) ctx.getBean("figureDaoHibernate4");
		Session s = figureDao.getSession();
		List<String> domains = s.createQuery(hql).list();
		return domains;
	}
	public static List<String> getJobs() {
		String hql ="select f.job from Figure f group by f.job ORDER BY count(*) DESC";
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		FigureDao figureDao = (FigureDao) ctx.getBean("figureDaoHibernate4");
		Session s = figureDao.getSession();
		List<String> jobs = s.createQuery(hql).list();
		return jobs;
	}
	@Override
	public List<Figure> getAll(String domain,boolean zhonghua) {
		String hql = null;
		List<Figure> figures =  null;
		Session s = figureDao.getSession();
		if(StringUtils.isNotEmpty(domain)){
			hql = "from Figure f where f.domain =:domain " + (zhonghua?"and f.nation.zhonghua = 1 order by f.nation":"order by f.nation");
			figures = s.createQuery(hql).setParameter("domain", domain).list();
		}else{
			hql = "from Figure f where " + (zhonghua?"f.nation.zhonghua = 1 order by f.nation":"1 = 1 order by f.nation");
			figures = s.createQuery(hql).list();
		}
		return figures;
	}
	@Override
	public JSONArray getTree(String domain) {
		JSONArray tree = new JSONArray();
		String hql0 = null;
		Session s = figureDao.getSession();
		List<Figure> cs = null;
		if(StringUtils.isNotEmpty(domain)){
			hql0 = "from Figure f where f.nation.zhonghua = 0 and f.domain = :domain order by f.nation ";
			cs = s.createQuery(hql0).setParameter("domain", domain).list();
		}else{
			hql0 = "from Figure f where f.nation.zhonghua = 0 order by f.nation ";
			cs = s.createQuery(hql0).list();
		}
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<Figure> zh = getAll(domain,true);
		if(zh !=null && zh.size() > 0){
		for(Figure figure: zh){
			JSONObject zisun = new JSONObject();
			zisun.accumulate("id", figure.getId());
			zisun.accumulate("text", figure.getName());
			yanhuang.add(zisun);
		}
		zhonghua.accumulate("children", yanhuang);
		tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String nationName = ""; 
		for(Figure figure : cs){
			if(!figure.getNation().getName().equals(nationName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				nationName = figure.getNation().getName();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", nationName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", figure.getId());
				child.accumulate("text", figure.getName());
				children.add(child);
		}
		if(children != null){
		branch.accumulate("children", children);
		tree.add(branch);
		}
		return tree;
	}
}
