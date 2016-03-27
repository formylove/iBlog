package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.OpusDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Opus;
@Repository("opusDaoHibernate4")
public class OpusDaoHibernate4 extends BaseDaoHibernate4<Opus> implements OpusDao 
{	
	public OpusDaoHibernate4() {
	}

	@Override
	public Opus get(int id) {
		return get(Opus.class,id);
	}
	//父类有了就不用再写了
}
