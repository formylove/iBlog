package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.NationDao;
import main.src.entity.gallery.City;
import main.src.entity.gallery.Nation;
import main.src.service.NationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("nationService")
@Transactional
public class NationServiceImpl implements NationService {
	
	@Resource(name = "nationDaoHibernate4")
	private NationDao nationDao;
	
	public NationServiceImpl() {
	}

	public int save(Nation nation) {
		if(StringUtils.isNotEmpty(nation.getName())){
		Nation o = get(nation.getName());
		if(o == null){
			return nationDao.save(nation);
		}else{
			return o.getId();
		}
		}else{
			return 0;
		}
	}
	@Override
	public Nation get(String name) {
		String hql ="from Nation where name=:name";
		Session s = nationDao.getSession();
		Nation nation = (Nation)s.createQuery(hql).setParameter("name", name).
				setFirstResult(0).setMaxResults(1).uniqueResult();
		return nation;
	}
	@Override
	public void persist(Nation nation) {
		nationDao.persist(nation);
	}
	
	@Override
	public void delete(int id) {
		Nation n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Nation nation) {
		nationDao.delete(nation);
	}
	@Override
	public void update(Nation nation) {
		nationDao.update(nation);
	}
	@Override
	public Nation remove(int id) {
		Nation nation = get(id);
		return nation;
	}

	@Override
	public Nation get(int id) {
		return nationDao.get(id);
	}

	@Override
	public void recover(int id) {
	}

	public NationDao getNationDao() {
		return nationDao;
	}

	public void setNationDao(NationDao nationdao) {
		this.nationDao = nationdao;
	}

	@Override
	public List<Nation> getAll(boolean flag) {
		return nationDao.findAll(Nation.class);
	}
	@Override
	public List<Nation> getZhonghua() {
		String hql ="from Nation n where n.zhonghua = 1";
		Session s = nationDao.getSession();
		List<Nation> nations = (List<Nation>)s.createQuery(hql).list();
		return nations;
	}

	@Override
	public JSONArray getTree() {
		JSONArray tree = new JSONArray();
		String hql0 = "from Nation n where n.zhonghua = 0 order by n.continent ";
		Session s = nationDao.getSession();
		List<Nation> cs = s.createQuery(hql0).list();
		JSONObject m1 = new JSONObject();
		JSONObject m2 = new JSONObject();
		m1.accumulate("id", get("中国").getId());
		m1.accumulate("text", "中国");
		m2.accumulate("id", get("美国").getId());
		m2.accumulate("text", "美国");
		tree.add(m1);
		tree.add(m2);
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<Nation> zh = getZhonghua();
		if(zh !=null && zh.size() > 0){
		for(Nation nation:zh){
			JSONObject zisun = new JSONObject();
			zisun.accumulate("id", nation.getId());
			zisun.accumulate("text", nation.getName());
			yanhuang.add(zisun);
		}
		zhonghua.accumulate("children", yanhuang);
		tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String continentName = ""; 
		for(Nation nation : cs){
			if(!nation.getContinent().equals(continentName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				continentName = nation.getContinent();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", continentName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", nation.getId());
				child.accumulate("text", nation.getName());
				children.add(child);
		}
		if(children != null){
		branch.accumulate("children", children);
		tree.add(branch);
		}
		return tree;
	}
}
