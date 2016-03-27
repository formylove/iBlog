package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.RecordDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Record;
@Repository("recordDaoHibernate4")
public class RecordDaoHibernate4 extends BaseDaoHibernate4<Record> implements RecordDao 
{	
	public RecordDaoHibernate4() {
	}

	@Override
	public Record get(int id) {
		return get(Record.class,id);
	}
	//父类有了就不用再写了
}
