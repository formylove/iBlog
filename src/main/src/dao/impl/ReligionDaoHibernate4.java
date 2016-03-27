package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.ReligionDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.Religion;
@Repository("religionDaoHibernate4")
public class ReligionDaoHibernate4 extends BaseDaoHibernate4<Religion> implements ReligionDao 
{	
	public ReligionDaoHibernate4() {
	}

	@Override
	public Religion get(int id) {
		return get(Religion.class,id);
	}
	//父类有了就不用再写了
}
