package main.src.dao;

import main.src.dao.common.BaseDao;
import main.src.entity.User;

public interface UserDao extends BaseDao<User>{
	User get(int id);
}
