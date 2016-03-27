package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.OpusDao;
import main.src.entity.Opus;
import main.src.entity.essay.Essay;
import main.src.entity.Opus;
import main.src.service.OpusService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("opusService")
@Transactional
public class OpusServiceImpl implements OpusService {
	
	@Resource(name = "opusDaoHibernate4")
	private OpusDao opusDao;
	
	public OpusServiceImpl() {
	}

	public int save(Opus opus) {
		Opus o = get(opus.getName());
		if(o == null){
			return opusDao.save(opus);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(Opus opus) {
		opusDao.persist(opus);
	}
	
	@Override
	public void delete(int id) {
		Opus n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Opus opus) {
		opusDao.delete(opus);
	}
	@Override
	public void update(Opus opus) {
		opusDao.update(opus);
	}
	@Override
	public Opus remove(int id) {
		Opus opus = get(id);
		if(null != opus){
			opus.setDel_flag(true);
			opusDao.update(opus);
		}
		return opus;
	}

	@Override
	public Opus get(int id) {
		return opusDao.get(id);
	}
	@Override
	public Opus get(String name) {
		String hql ="from Opus where name=:name";
		Session s = opusDao.getSession();
		Opus opus = (Opus)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return opus;
	}

	@Override
	public void recover(int id) {
		Opus opus = get(id);
		if(null != opus){
			opus.setDel_flag(false);
			opusDao.update(opus);
		}
	}

	public OpusDao getOpusDao() {
		return opusDao;
	}

	public void setOpusDao(OpusDao opusdao) {
		this.opusDao = opusdao;
	}

	@Override
	public boolean hasExisted(String name) {
		String hql ="from Opus where name=:name";
		Session s = opusDao.getSession();
		Opus opus = (Opus)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return opus != null;
	}
	
	
	
	@Override
	public List<Opus> getZhonghua(String type) {
		String hql ="from Opus o where o.nation.zhonghua = 1 and o.type ='" + type + "'";
		Session s = opusDao.getSession();
		List<Opus> cities = (List<Opus>)s.createQuery(hql).list();
		return cities;
	}
	@Override
	public JSONArray getTree(String type) {
		JSONArray tree = new JSONArray();
		String hql0 = "from Opus o where o.nation.zhonghua = 0 and o.type ='" + type + "' order by o.nation.id ";
		Session s = opusDao.getSession();
		List<Opus> cs = s.createQuery(hql0).list();
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<Opus> zh = getZhonghua(type);
		if(zh !=null && zh.size() > 0){
			for(Opus opus: zh){
				
				JSONObject zisun = new JSONObject();
				zisun.accumulate("id", opus.getId());
				zisun.accumulate("text", opus.getName());
				yanhuang.add(zisun);
			}
			zhonghua.accumulate("children", yanhuang);
			tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String nationName = ""; 
		for(Opus opus : cs){
			if(!opus.getNation().getName().equals(nationName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				nationName = opus.getNation().getName();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", nationName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", opus.getId());
				child.accumulate("text", opus.getName());
				children.add(child);
		}
		if(children != null){
		branch.accumulate("children", children);
		tree.add(branch);
		}
		return tree;
	}

	@Override
	public JSONArray getTree() {
		JSONArray forest = new JSONArray();
		JSONObject movies = new JSONObject();
		movies.accumulate("text", "电影");
		movies.accumulate("state", "closed");
		movies.accumulate("children", getTree("movie"));
		JSONObject books = new JSONObject();
		books.accumulate("text", "书籍");
		books.accumulate("state", "closed");
		books.accumulate("children", getTree("book"));
		forest.add(movies);
		forest.add(books);
		return null;
	}



}
