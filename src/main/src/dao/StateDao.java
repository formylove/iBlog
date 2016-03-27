package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.gallery.State;

public interface StateDao extends BaseDao<State>{
	State get(int id);
}
