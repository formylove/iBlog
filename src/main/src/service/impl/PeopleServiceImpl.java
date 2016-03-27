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

import main.src.dao.FigureDao;
import main.src.dao.PeopleDao;
import main.src.entity.gallery.People;
import main.src.service.PeopleService;
@Service("peopleService")
@Transactional
public class PeopleServiceImpl implements PeopleService {
	
	@Resource(name = "peopleDaoHibernate4")
	private PeopleDao peopleDao;
	
	public PeopleServiceImpl() {
	}

	public int save(People people) {
		People o = get(people.getName());
		if(o == null){
			return peopleDao.save(people);
		}else{
			return o.getId();
		}
	}
	@Override
	public void persist(People people) {
		peopleDao.persist(people);
	}
	
	@Override
	public void delete(int id) {
		People n = get(id); 
		delete(n);
	}

	@Override
	public void delete(People people) {
		peopleDao.delete(people);
	}
	@Override
	public void update(People people) {
		peopleDao.update(people);
	}
	@Override
	public People remove(int id) {
		People people = get(id);
		return people;
	}

	@Override
	public People get(int id) {
		return peopleDao.get(id);
	}
	@Override
	public People get(String name) {
		String hql ="from People where name=:name";
		Session s = peopleDao.getSession();
		People people = (People)s.createQuery(hql).setParameter("name", name).
		setFirstResult(0).setMaxResults(1).uniqueResult();
		return people;
	}

	@Override
	public void recover(int id) {
	}

	public PeopleDao getPeopleDao() {
		return peopleDao;
	}

	public void setPeopleDao(PeopleDao peopledao) {
		this.peopleDao = peopledao;
	}
	public static List<People> getPeoples() {
		String hql ="from People";
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		PeopleDao peopleDao = (PeopleDao) ctx.getBean("peopleDaoHibernate4");
		Session s = peopleDao.getSession();
		List<People> peoples = s.createQuery(hql).list();
		return peoples;
	}
}
