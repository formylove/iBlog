package test;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import main.src.entity.User;
import main.src.service.UserService;

public class TestAction {
	User user;
	int id;
	public String test(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		HttpServletResponse res = (HttpServletResponse) ActionContext.getContext().get(StrutsStatics.HTTP_RESPONSE);
		if(id!=0){
			Cookie c = new Cookie("night_user_id",String.valueOf(id));
			c.setMaxAge(3600);
			res.addCookie(c);
		}else{
			UserService.logout();
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
