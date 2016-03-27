package main.src.dao;


import main.src.dao.common.BaseDao;
import main.src.entity.gallery.Religion;

public interface ReligionDao extends BaseDao<Religion>{
	Religion get(int id);
}
