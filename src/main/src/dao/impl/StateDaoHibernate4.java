package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.StateDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.gallery.State;
@Repository("stateDaoHibernate4")
public class StateDaoHibernate4 extends BaseDaoHibernate4<State> implements StateDao 
{	
	public StateDaoHibernate4() {
	}

	@Override
	public State get(int id) {
		return get(State.class,id);
	}
	//父类有了就不用再写了
}
