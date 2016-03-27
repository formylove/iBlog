package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.NationDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.Nation;
@Repository("nationDaoHibernate4")
public class NationDaoHibernate4 extends BaseDaoHibernate4<Nation> implements NationDao 
{	
	public NationDaoHibernate4() {
	}

	@Override
	public Nation get(int id) {
		return get(Nation.class,id);
	}
	//父类有了就不用再写了
}
