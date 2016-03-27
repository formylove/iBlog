package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.gallery.People;

public interface PeopleDao extends BaseDao<People>{
	People get(int id);
}
