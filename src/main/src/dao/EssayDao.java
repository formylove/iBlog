package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.essay.Essay;

public interface EssayDao extends BaseDao<Essay>{
	Essay get(int id);
}
