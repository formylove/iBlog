package main.src.dao;



import main.src.dao.common.BaseDao;
import main.src.entity.Category;

public interface CategoryDao extends BaseDao<Category>{
	Category get(int id);
}
