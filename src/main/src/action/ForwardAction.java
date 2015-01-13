package main.src.action;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import main.src.common.Log;

public class ForwardAction {

	
	public String forward(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		Log.print(request.getParameter("url"));
		
		return null;
	}
}
