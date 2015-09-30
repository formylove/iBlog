package main.src.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.SqlUtils;
import main.src.common.WebUtils;
import main.src.entity.User;

public class UserService {
	
	static public String getUserName(int id){
		return getUser(id).getNick_name();
	}
	static public boolean isLogined(HttpServletRequest request){
		String user_id = WebUtils.getCookie("night_user_id",request);
		if(user_id == null){
			return false;
		}
		return true;
	}
	
	static public User getUser(int id){
		String sql="select * from user where id="+id;
		@SuppressWarnings("unchecked")
		User user=((List<User>)SqlUtils.executeQuery(sql, null, User.class)).get(0);
		return user;
	}
	static public User getcurLoginUser(HttpServletRequest request){
		String user_id = WebUtils.getCookie("night_user_id",request);
		if(user_id != null){
			return getUser(Integer.parseInt(user_id));
		}
			return null;
	}
}
