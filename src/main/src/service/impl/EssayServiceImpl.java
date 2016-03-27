package main.src.service.impl;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.EssayDao;
import main.src.entity.essay.Essay;
import main.src.service.EssayService;
@Service("essayService")
@Transactional
public class EssayServiceImpl implements EssayService {
	
	@Resource(name = "essayDaoHibernate4")
	private EssayDao essayDao;
	
	public EssayServiceImpl() {
	}

	public int save(Essay essay) {
		Essay e = get(essay.getTitle());
		if(e == null){
			return essayDao.save(essay);
		}else{
			return e.getId();
		}
	}

	@Override
	public void persist(Essay essay) {
		essayDao.persist(essay);
	}
	
	@Override
	public void delete(int id) {
		Essay n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Essay essay) {
		essayDao.delete(essay);
	}
	@Override
	public void update(Essay essay) {
		essayDao.update(essay);
	}

	@Override
	public Essay get(int id) {
		return essayDao.get(id);
	}
	@Override
	public Essay get(String title) {
		String hql ="from Essay where title=:title";
		Session s = essayDao.getSession();
		@SuppressWarnings("unchecked")
		Essay essay = (Essay)s.createQuery(hql).setParameter("title", title).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return essay;
	}
	
	@Override
	public Essay remove(int id) {
		Essay essay = get(id);
		if(null != essay){
			essay.setDel_flag(true);
			essayDao.update(essay);
		}
		return essay;
	}

	@Override
	public void recover(int id) {
		Essay essay = get(id);
		if(null != essay){
			essay.setDel_flag(false);
			essayDao.update(essay);
		}
	}

	@Override
	public void read(int id) {
		Essay essay = get(id);
		if(null != essay){
			essay.setRead_cnt(essay.getRead_cnt() + 1);
			essayDao.update(essay);
		}
	}
	@Override
	public void like(int id) {
		Essay essay = get(id);
		if(null != essay){
			essay.setFavor_cnt(essay.getFavor_cnt() + 1);
			essayDao.update(essay);
		}
	}
	@Override
	public void undoLike(int id) {
		Essay essay = get(id);
		if(null != essay){
			if(essay.getFavor_cnt() > 0){
				essay.setFavor_cnt(essay.getFavor_cnt() - 1);
			}
			essayDao.update(essay);
		}
	}

	@Override
	public boolean hasExisted(String title) {
		String hql ="from Essay where title=:title";
		Session s = essayDao.getSession();
		@SuppressWarnings("unchecked")
		Essay essay = (Essay)s.createQuery(hql).setParameter("title", title).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return essay != null;
	}

	public EssayDao getEssayDao() {
		return essayDao;
	}

	public void setEssayDao(EssayDao essaydao) {
		this.essayDao = essaydao;
	}



}
