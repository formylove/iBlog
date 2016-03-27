package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.GenreDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Genre;
@Repository("genreDaoHibernate4")
public class GenreDaoHibernate4 extends BaseDaoHibernate4<Genre> implements GenreDao 
{	
	public GenreDaoHibernate4() {
	}

	@Override
	public Genre get(int id) {
		return get(Genre.class,id);
	}
	//父类有了就不用再写了
}
