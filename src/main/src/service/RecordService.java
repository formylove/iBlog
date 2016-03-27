package main.src.service;

import main.src.entity.Record;
import main.src.service.base.BaseService;

public interface RecordService extends BaseService<Record>{

	Record getRecordByToken(String token);
}
