package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.DynastyDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.Dynasty;
@Repository("dynastyDaoHibernate4")
public class DynastyDaoHibernate4 extends BaseDaoHibernate4<Dynasty> implements DynastyDao 
{	
	public DynastyDaoHibernate4() {
	}

	@Override
	public Dynasty get(int id) {
		return get(Dynasty.class,id);
	}
	//父类有了就不用再写了
}
