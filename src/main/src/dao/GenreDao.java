package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Genre;

public interface GenreDao extends BaseDao<Genre>{
	Genre get(int id);
}
