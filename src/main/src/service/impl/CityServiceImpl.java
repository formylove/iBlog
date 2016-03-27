package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.CityDao;
import main.src.entity.gallery.City;
import main.src.entity.gallery.Nation;
import main.src.entity.gallery.State;
import main.src.service.CityService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
	
	@Resource(name = "cityDaoHibernate4")
	private CityDao cityDao;
	
	public CityServiceImpl() {
	}

	public int save(City city) {
		City o = get(city.getName());
		if(o == null){
			return cityDao.save(city);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(City city) {
		cityDao.persist(city);
	}
	
	@Override
	public void delete(int id) {
		City n = get(id); 
		delete(n);
	}

	@Override
	public void delete(City city) {
		cityDao.delete(city);
	}
	@Override
	public void update(City city) {
		cityDao.update(city);
	}
	@Override
	public City remove(int id) {
		City city = get(id);
		return city;
	}

	@Override
	public City get(int id) {
		return cityDao.get(id);
	}
	@Override
	public City get(String name) {
		String hql ="from City where name=:name";
		Session s = cityDao.getSession();
		City city = (City)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return city;
	}

	@Override
	public void recover(int id) {
	}

	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao citydao) {
		this.cityDao = citydao;
	}
	@Override
	public List<City> getZhonghua() {
		String hql ="from City c where c.nation.zhonghua = 1";
		Session s = cityDao.getSession();
		List<City> cities = (List<City>)s.createQuery(hql).list();
		return cities;
	}
	@Override
	public JSONArray getTree() {
		JSONArray tree = new JSONArray();
		String hql0 = "from City c where c.nation.zhonghua = 0 order by c.nation ";
		Session s = cityDao.getSession();
		List<City> cs = s.createQuery(hql0).list();
		////////////////////////zhonghua////////////////////
		JSONObject zhonghua = new JSONObject();
		zhonghua.accumulate("text", "中华");
		zhonghua.accumulate("state", "closed");
		JSONArray yanhuang = new JSONArray();
		List<City> zh = getZhonghua();
		if(zh !=null && zh.size() > 0){
			for(City city: zh){
				
				JSONObject zisun = new JSONObject();
				zisun.accumulate("id", city.getId());
				zisun.accumulate("text", city.getName());
				yanhuang.add(zisun);
			}
			zhonghua.accumulate("children", yanhuang);
			tree.add(zhonghua);
		}
		////////////////////////continent//////////////////
		JSONObject branch = null;
		JSONArray children = null;
		String nationName = ""; 
		for(City city : cs){
			if(!city.getNation().getName().equals(nationName)){
				if(children != null){
					branch.accumulate("children", children);//必须先填满值才能add
					tree.add(branch);
				}
				nationName = city.getNation().getName();
				children = new JSONArray();
				branch = new JSONObject();
				branch.accumulate("text", nationName);
				branch.accumulate("state", "closed");
			}
				JSONObject child = new JSONObject();
				child.accumulate("id", city.getId());
				child.accumulate("text", city.getName());
				children.add(child);
		}
		if(children != null){
		branch.accumulate("children", children);
		tree.add(branch);
		}
		return tree;
	}
}
