package main.src.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;


public class WebUtils {
static public String getCookie(String name,HttpServletRequest request){
	if(request == null){
		ActionContext act = ActionContext.getContext();
		request = (HttpServletRequest)act.get(StrutsStatics.HTTP_REQUEST);
		
	}
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
	for(Cookie cookie:cookies){
		if(name.equalsIgnoreCase(cookie.getName())){
			return cookie.getValue();
		}
	}
	}
	return null;
}
}
