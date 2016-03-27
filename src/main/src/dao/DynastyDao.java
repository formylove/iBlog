package main.src.dao;


import main.src.dao.common.BaseDao;
import main.src.entity.Record;
import main.src.entity.gallery.Dynasty;

public interface DynastyDao extends BaseDao<Dynasty>{
	Dynasty get(int id);
}
