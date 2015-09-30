package test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import main.src.entity.User;

public class TestAction {
	User user;
	int id;
	public String test(){
		HttpServletResponse res = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		if(id!=0){
			Cookie c = new Cookie("night_user_id",String.valueOf(id));
			c.setMaxAge(3600);
			res.addCookie(c);
		}else{
			Cookie c = new Cookie("night_user_id",null);
			c.setMaxAge(0);
			res.addCookie(c);
		}
		if(user!=null)
		System.out.println(user.getNick_name());
		return "test";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
