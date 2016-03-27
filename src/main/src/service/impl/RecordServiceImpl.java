package main.src.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.RecordDao;
import main.src.entity.Record;
import main.src.service.RecordService;
@Service("recordService")
@Transactional
public class RecordServiceImpl implements RecordService {
	@Resource(name = "recordDaoHibernate4")
	private RecordDao recordDao;
	
	public RecordServiceImpl() {
	}

	public int save(Record record) {
		return recordDao.save(record);
	}

	@Override
	public void persist(Record record) {
		recordDao.persist(record);
	}
	
	@Override
	public void delete(int id) {
		Record n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Record record) {
		recordDao.delete(record);
	}
	@Override
	public Record getRecordByToken(String session_id) {
		String hql = "from Record where session_id = :session_id";
		Record record = (Record)recordDao.getSession().createQuery(hql)
				.setString("session_id", session_id)
				.setMaxResults(1)
				.uniqueResult();
		return record;
	}
	@Override
	public void update(Record record) {
		recordDao.update(record);
	}
	@Override
	public Record remove(int id) {
		return null;
	}

	@Override
	public Record get(int id) {
		return recordDao.get(id);
	}

	@Override
	public void recover(int id) {
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recorddao) {
		this.recordDao = recorddao;
	}




}
