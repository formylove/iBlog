package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.EssayDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.essay.Essay;
@Repository("essayDaoHibernate4")
public class EssayDaoHibernate4 extends BaseDaoHibernate4<Essay> implements EssayDao 
{	
	public EssayDaoHibernate4() {
	}

	@Override
	public Essay get(int id) {
		return get(Essay.class,id);
	}
	//父类有了就不用再写了
}
