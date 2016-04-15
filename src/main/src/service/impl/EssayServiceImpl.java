package main.src.service.impl;


import java.util.List;

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
	final int MAXSIZE = 10;
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
	public List<Essay> getHomepageList() {
		String hql ="from Essay where del_flag = 0 order by id desc";
		Session s = essayDao.getSession();
		List<Essay> essays = (List<Essay>)s.createQuery(hql).setMaxResults(3).list();
		return essays;
	}
	@Override
	public List<Essay> getOnePage(int page,int category) {
		String hql = "from Essay ";
		if(category != 0){
			hql +="where category = " + category;
		}
		List<Essay> essays = essayDao.findByPage(hql, page, MAXSIZE);
		return essays;
	}
	@Override
	public int getPageCnt(int category) {
		String hql = "select count(*) from Essay where del_flag = 0";
		if(category != 0){
			hql +="and category = " + category;
		}
		int cnt = ((Long)essayDao.getSession().createQuery(hql).uniqueResult()).intValue();
		return (cnt/MAXSIZE) + (cnt%MAXSIZE==0?0:1);
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
