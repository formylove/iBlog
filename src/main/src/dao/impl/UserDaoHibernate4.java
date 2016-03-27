package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.UserDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.User;
@Repository("userDaoHibernate4")
public class UserDaoHibernate4 extends BaseDaoHibernate4<User> implements UserDao 
{	
	public UserDaoHibernate4() {
	}

	@Override
	public User get(int id) {
		return get(User.class,id);
	}
	//父类有了就不用再写了
}
