package main.src.service.impl;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.SceneryDao;
import main.src.entity.gallery.item.Scenery;
import main.src.service.SceneryService;
@Service("sceneryService")
@Transactional
public class SceneryServiceImpl implements SceneryService {
	
	@Resource(name = "sceneryDaoHibernate4")
	private SceneryDao sceneryDao;
	
	public SceneryServiceImpl() {
	}

	public int save(Scenery scenery) {
		Scenery o = get(scenery.getName());
		if(o == null){
			return sceneryDao.save(scenery);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(Scenery scenery) {
		sceneryDao.persist(scenery);
	}
	
	@Override
	public void delete(int id) {
		Scenery n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Scenery scenery) {
		sceneryDao.delete(scenery);
	}
	@Override
	public void update(Scenery scenery) {
		sceneryDao.update(scenery);
	}
	@Override
	public Scenery remove(int id) {
		Scenery scenery = get(id);
		return scenery;
	}

	@Override
	public Scenery get(int id) {
		return sceneryDao.get(id);
	}
	@Override
	public Scenery get(String name) {
		String hql ="from Scenery where name=:name";
		Session s = sceneryDao.getSession();
		Scenery scenery = (Scenery)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return scenery;
	}

	@Override
	public void recover(int id) {
	}

	public SceneryDao getSceneryDao() {
		return sceneryDao;
	}

	public void setSceneryDao(SceneryDao scenerydao) {
		this.sceneryDao = scenerydao;
	}
}
