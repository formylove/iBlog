package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Music;

public interface MusicDao extends BaseDao<Music>{
	Music get(int id);
}
