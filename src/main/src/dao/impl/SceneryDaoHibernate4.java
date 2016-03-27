package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.SceneryDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.item.Scenery;
@Repository("sceneryDaoHibernate4")
public class SceneryDaoHibernate4 extends BaseDaoHibernate4<Scenery> implements SceneryDao 
{	
	public SceneryDaoHibernate4() {
	}

	@Override
	public Scenery get(int id) {
		return get(Scenery.class,id);
	}
	//父类有了就不用再写了
}
