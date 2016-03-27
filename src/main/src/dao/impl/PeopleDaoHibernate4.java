package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.PeopleDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.People;
@Repository("peopleDaoHibernate4")
public class PeopleDaoHibernate4 extends BaseDaoHibernate4<People> implements PeopleDao 
{	
	public PeopleDaoHibernate4() {
	}

	@Override
	public People get(int id) {
		return get(People.class,id);
	}
	//父类有了就不用再写了
}
