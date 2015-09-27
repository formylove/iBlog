package main.src.service;

import java.util.List;

import main.src.common.SqlUtils;
import main.src.entity.User;

public class UserService {
	
	static public String getUserName(int id){
		return getUser(id).getNick_name();
	}
	static public User getUser(int id){
		String sql="select * from user where id="+id;
		@SuppressWarnings("unchecked")
		User user=((List<User>)SqlUtils.executeQuery(sql, null, User.class)).get(0);
		return user;
	}
	static public User getcurLoginUser(){
		return getUser(2);
	}
}
