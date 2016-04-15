package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Poster;

public interface PosterDao extends BaseDao<Poster>{
	Poster get(int id);
}
