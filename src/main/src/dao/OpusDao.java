package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Note;
import main.src.entity.Opus;

public interface OpusDao extends BaseDao<Opus>{
	Opus get(int id);
}
