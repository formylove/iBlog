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

import main.src.dao.CorporationDao;
import main.src.entity.gallery.Corporation;
import main.src.entity.gallery.item.Figure;
import main.src.service.CorporationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("corporationService")
@Transactional
public class CorporationServiceImpl implements CorporationService {
	
	@Resource(name = "corporationDaoHibernate4")
	private CorporationDao corporationDao;
	
	public CorporationServiceImpl() {
	}

	public int save(Corporation corporation) {
		Corporation o = get(corporation.getName());
		if(o == null){
			return corporationDao.save(corporation);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(Corporation corporation) {
		corporationDao.persist(corporation);
	}
	
	@Override
	public void delete(int id) {
		Corporation n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Corporation corporation) {
		corporationDao.delete(corporation);
	}
	@Override
	public void update(Corporation corporation) {
		corporationDao.update(corporation);
	}
	@Override
	public Corporation remove(int id) {
		Corporation corporation = get(id);
		return corporation;
	}

	@Override
	public Corporation get(int id) {
		return corporationDao.get(id);
	}
	@Override
	public Corporation get(String name) {
		String hql ="from Corporation where name=:name";
		Session s = corporationDao.getSession();
		Corporation corporation = (Corporation)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return corporation;
	}

	@Override
	public void recover(int id) {
	}

	public CorporationDao getCorporationDao() {
		return corporationDao;
	}

	public void setCorporationDao(CorporationDao corporationdao) {
		this.corporationDao = corporationdao;
	}
	public static List<String> getIndustries() {
		String hql ="select c.industry from Corporation c group by c.industry ORDER BY count(*) DESC";
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		CorporationDao corporationDao = (CorporationDao) ctx.getBean("corporationDaoHibernate4");
		Session s = corporationDao.getSession();
		List<String> industries = s.createQuery(hql).list();
		return industries;
	}
	@Override
	public List<Corporation> getAll(String industry,boolean zhonghua) {
		String hql = null;
		List<Corporation> corporations =  null;
		Session s = corporationDao.getSession();
		if(StringUtils.isNotEmpty(industry)){
			hql = "from Corporation c where c.industry =:industry " + (zhonghua?"and c.nation.zhonghua = 1 order by c.nation":"order by c.nation.id");
			corporations = s.createQuery(hql).setParameter("industry", industry).list();
		}else{
			hql = "from Corporation c where " + (zhonghua?"c.nation.zhonghua = 1 order by c.nation":"1 = 1 order by c.nation.id");
			corporations = s.createQuery(hql).list();
		}
		return corporations;
	}
	public JSONArray getTree(String industry) {
		JSONArray tree = new JSONArray();
		String hql0 = null;
		Session s = corporationDao.getSession();
		List<Corporation> cs = null;
		if(StringUtils.isNotEmpty(industry)){
			hql0 = "from Corporation c where c.nation.zhonghua = 0 and c.industry = :industry order by c.nation.id ";
			cs = s.createQuery(hql0).setParameter("industry", industry).list();
		}else{
			hql0 = "from Corporation c where c.nation.zhonghua = 0 order by c.nation.id ";
			cs = s.createQuery(hql0).list();
		}
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<Corporation> zh = getAll(industry,true);
		if(zh !=null && zh.size() > 0){
		for(Corporation corporation: zh){
			JSONObject zisun = new JSONObject();
			zisun.accumulate("id", corporation.getId());
			zisun.accumulate("text", corporation.getName());
			yanhuang.add(zisun);
		}
		zhonghua.accumulate("children", yanhuang);
		tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String nationName = ""; 
		for(Corporation corporation : cs){
			if(!corporation.getNation().getName().equals(nationName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				nationName = corporation.getNation().getName();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", nationName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", corporation.getId());
				child.accumulate("text", corporation.getName());
				children.add(child);
		}
		if(children != null){
		branch.accumulate("children", children);
		tree.add(branch);
		}
		return tree;
	}
}
