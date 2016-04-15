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

import main.src.dao.PosterDao;
import main.src.entity.Poster;
import main.src.service.PosterService;
@Service("posterService")
@Transactional
public class PosterServiceImpl implements PosterService {
	
	@Resource(name = "posterDaoHibernate4")
	private PosterDao posterDao;
	
	public PosterServiceImpl() {
	}

	public int save(Poster poster) {
		if(StringUtils.isNotEmpty(poster.getCover())){
			return posterDao.save(poster);
		}else{
			return 0;
		}
	}
	@Override
	public Poster get(String name) {
		String hql ="from Poster where name=:name";
		Session s = posterDao.getSession();
		Poster poster = (Poster)s.createQuery(hql).setParameter("name", name).
				setFirstResult(0).setMaxResults(1).uniqueResult();
		return poster;
	}

	@Override
	public void persist(Poster poster) {
		posterDao.persist(poster);
	}
	
	@Override
	public void delete(int id) {
		Poster n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Poster poster) {
		posterDao.delete(poster);
	}
	@Override
	public void update(Poster poster) {
		posterDao.update(poster);
	}
	@Override
	public Poster remove(int id) {
		return null;
	}
	@Override
	public List<Poster> list() {
		return posterDao.getSession().createQuery("from Poster c Order by order").list();
	}
	@Override
	public void updateOrder(int before,int after) {
		 posterDao.getSession().createQuery("update Poster c set c.order =:after where c.id =:before")
		 .setParameter("after", after)
		 .setParameter("before", before)
		 .executeUpdate();
	}

	@Override
	public Poster get(int id) {
		return posterDao.get(id);
	}

	@Override
	public void recover(int id) {
	}

	public PosterDao getPosterDao() {
		return posterDao;
	}

	public void setPosterDao(PosterDao posterdao) {
		this.posterDao = posterdao;
	}
	public static List<Poster> getAll(){
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		PosterDao posterDao = (PosterDao) ctx.getBean("posterDaoHibernate4");
		List<Poster> cats = posterDao.findAll(Poster.class);
		return cats;
	}



}
