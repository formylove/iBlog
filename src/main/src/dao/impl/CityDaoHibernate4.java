package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.CityDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.City;
@Repository("cityDaoHibernate4")
public class CityDaoHibernate4 extends BaseDaoHibernate4<City> implements CityDao 
{	
	public CityDaoHibernate4() {
	}

	@Override
	public City get(int id) {
		return get(City.class,id);
	}
	//父类有了就不用再写了
}
