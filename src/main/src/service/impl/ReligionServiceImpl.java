package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import main.src.dao.PeopleDao;
import main.src.dao.ReligionDao;
import main.src.entity.gallery.People;
import main.src.entity.gallery.Religion;
import main.src.service.ReligionService;
@Service("religionService")
@Transactional
public class ReligionServiceImpl implements ReligionService {
	
	@Resource(name = "religionDaoHibernate4")
	private ReligionDao religionDao;
	
	public ReligionServiceImpl() {
	}

	public int save(Religion religion) {
		Religion o = get(religion.getName());
		if(o == null){
			return religionDao.save(religion);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(Religion religion) {
		religionDao.persist(religion);
	}
	
	@Override
	public void delete(int id) {
		Religion n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Religion religion) {
		religionDao.delete(religion);
	}
	@Override
	public void update(Religion religion) {
		religionDao.update(religion);
	}
	@Override
	public Religion remove(int id) {
		Religion religion = get(id);
		return religion;
	}

	@Override
	public Religion get(int id) {
		return religionDao.get(id);
	}
	@Override
	public Religion get(String name) {
		String hql ="from Religion where name=:name";
		Session s = religionDao.getSession();
		Religion religion = (Religion)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return religion;
	}

	@Override
	public void recover(int id) {
	}

	public ReligionDao getReligionDao() {
		return religionDao;
	}

	public void setReligionDao(ReligionDao religiondao) {
		this.religionDao = religiondao;
	}
	public static List<Religion> getReligions() {
		String hql ="from Religion";
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		ReligionDao religionDao = (ReligionDao) ctx.getBean("religionDaoHibernate4");
		Session s = religionDao.getSession();
		List<Religion> peoples = s.createQuery(hql).list();
		return peoples;
	}
}
