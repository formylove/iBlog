package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Music;
import main.src.entity.gallery.Nation;

public interface NationDao extends BaseDao<Nation>{
	Nation get(int id);
}
