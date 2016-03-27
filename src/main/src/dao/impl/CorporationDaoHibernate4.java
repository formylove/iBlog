package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.CorporationDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.Corporation;
@Repository("corporationDaoHibernate4")
public class CorporationDaoHibernate4 extends BaseDaoHibernate4<Corporation> implements CorporationDao 
{	
	public CorporationDaoHibernate4() {
	}

	@Override
	public Corporation get(int id) {
		return get(Corporation.class,id);
	}
	//父类有了就不用再写了
}
