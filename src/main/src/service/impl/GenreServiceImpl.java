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

import main.src.dao.GenreDao;
import main.src.entity.Genre;
import main.src.entity.Opus;
import main.src.service.GenreService;
@Service("genreService")
@Transactional
public class GenreServiceImpl implements GenreService {
	
	@Resource(name = "genreDaoHibernate4")
	private GenreDao genreDao;
	
	public GenreServiceImpl() {
	}

	public int save(Genre genre) {
		if(StringUtils.isNotEmpty(genre.getName())){
		Genre o = get(genre.getName());
		if(o == null){
			return genreDao.save(genre);
		}else{
			return o.getId();
		}
		}else{
			return 0;
		}
	}
	@Override
	public Genre get(String name) {
		String hql ="from Genre where name=:name";
		Session s = genreDao.getSession();
		Genre genre = (Genre)s.createQuery(hql).setParameter("name", name).
				setFirstResult(0).setMaxResults(1).uniqueResult();
		return genre;
	}

	@Override
	public void persist(Genre genre) {
		genreDao.persist(genre);
	}
	
	@Override
	public void delete(int id) {
		Genre n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Genre genre) {
		genreDao.delete(genre);
	}
	@Override
	public void update(Genre genre) {
		genreDao.update(genre);
	}
	@Override
	public Genre remove(int id) {
			genreDao.delete(Genre.class, id);
		return null;
	}

	@Override
	public Genre get(int id) {
		return genreDao.get(id);
	}

	@Override
	public void recover(int id) {
	}
	@Override
	public void injectGenres(Opus opus,String[] genres) {
		Genre genre = null;
		for(String g : genres){
			genre = get(Integer.parseInt(g));
			opus.getGenres().add(genre);
		}
	}

	public GenreDao getGenreDao() {
		return genreDao;
	}

	public void setGenreDao(GenreDao genredao) {
		this.genreDao = genredao;
	}
	public static List<Genre> getAll(){
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		GenreDao genreDao = (GenreDao) ctx.getBean("genreDaoHibernate4");
		List<Genre> genres = genreDao.findAll(Genre.class);
		return genres;
	}



}
