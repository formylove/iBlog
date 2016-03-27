package main.src.dao;


import main.src.dao.common.BaseDao;
import main.src.entity.Record;

public interface RecordDao extends BaseDao<Record>{
	Record get(int id);
}
