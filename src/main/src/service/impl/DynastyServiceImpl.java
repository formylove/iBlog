package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.DynastyDao;
import main.src.entity.gallery.Dynasty;
import main.src.entity.gallery.Dynasty;
import main.src.service.DynastyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("dynastyService")
@Transactional
public class DynastyServiceImpl implements DynastyService {
	
	@Resource(name = "dynastyDaoHibernate4")
	private DynastyDao dynastyDao;
	
	public DynastyServiceImpl() {
	}

	public int save(Dynasty dynasty) {
		Dynasty o = get(dynasty.getName());
		if(o == null){
			return dynastyDao.save(dynasty);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(Dynasty dynasty) {
		dynastyDao.persist(dynasty);
	}
	
	@Override
	public void delete(int id) {
		Dynasty n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Dynasty dynasty) {
		dynastyDao.delete(dynasty);
	}
	@Override
	public void update(Dynasty dynasty) {
		dynastyDao.update(dynasty);
	}
	@Override
	public Dynasty remove(int id) {
		Dynasty dynasty = get(id);
		return dynasty;
	}

	@Override
	public Dynasty get(int id) {
		return dynastyDao.get(id);
	}
	@Override
	public Dynasty get(String name) {
		String hql ="from Dynasty where name=:name";
		Session s = dynastyDao.getSession();
		Dynasty dynasty = (Dynasty)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return dynasty;
	}

	@Override
	public void recover(int id) {
	}

	public DynastyDao getDynastyDao() {
		return dynastyDao;
	}

	public void setDynastyDao(DynastyDao dynastydao) {
		this.dynastyDao = dynastydao;
	}

	@Override
	public JSONArray getTree() {
			JSONArray tree = new JSONArray();
			////////////////////////zhonghua////////////////////
			JSONObject zhonghua = new JSONObject();
			zhonghua.accumulate("text", "中华");
			zhonghua.accumulate("state", "closed");
			JSONArray yanhuang = new JSONArray();
			List<Dynasty> zh = getZhonghua(true);
			if(zh !=null && zh.size() > 0){
				for(Dynasty dynasty: zh){
					
					JSONObject zisun = new JSONObject();
					zisun.accumulate("id", dynasty.getId());
					zisun.accumulate("text", dynasty.getName());
					yanhuang.add(zisun);
				}
				zhonghua.accumulate("children", yanhuang);
				tree.add(zhonghua);
			}
			////////////////////////zhonghua////////////////////
			JSONObject foreign = new JSONObject();
			foreign.accumulate("text", "国外");
			foreign.accumulate("state", "closed");
			JSONArray xiou = new JSONArray();
			List<Dynasty> fr = getZhonghua(false);
			if(fr !=null && fr.size() > 0){
				for(Dynasty dynasty: fr){
					
					JSONObject bangyang = new JSONObject();
					bangyang.accumulate("id", dynasty.getId());
					bangyang.accumulate("text", dynasty.getName());
					xiou.add(bangyang);
				}
				foreign.accumulate("children", xiou);
				tree.add(foreign);
			}
		return tree;
	}

	@Override
	public List<Dynasty> getZhonghua(boolean zhonghua) {
		String hql ="from Dynasty d where d.zhonghua = "+(zhonghua?1:0);
		Session s = dynastyDao.getSession();
		List<Dynasty> dynasties = (List<Dynasty>)s.createQuery(hql).list();
		return dynasties;
	}
}
