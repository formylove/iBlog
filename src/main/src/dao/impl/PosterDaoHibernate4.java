package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.PosterDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Poster;
@Repository("posterDaoHibernate4")
public class PosterDaoHibernate4 extends BaseDaoHibernate4<Poster> implements PosterDao 
{	
	public PosterDaoHibernate4() {
	}

	@Override
	public Poster get(int id) {
		return get(Poster.class,id);
	}
	//父类有了就不用再写了
}
