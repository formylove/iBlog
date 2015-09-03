package main.src.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import main.src.common.Log;
import main.src.common.MsgConstants;
import main.src.service.DiaryService;

public class ForwardAction {
String url;
boolean hasForwarded;
	
	public String forward(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		url = request.getParameter("url");
		Log.print(url);
		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域请求的问题，这个header就是让服务器支持CORS的
		hasForwarded = DiaryService.forward(url);
		return MsgConstants.SUCCESS;
	}
	
	public String hasForwarded(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		url = request.getParameter("url");
		Log.print(url);
		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域请求的问题，这个header就是让服务器支持CORS的
		hasForwarded = DiaryService.hasForwarded(url);
		return MsgConstants.SUCCESS;
	}


	public boolean isHasForwarded() {
		return hasForwarded;
	}

	public void setHasForwarded(boolean hasForwarded) {
		this.hasForwarded = hasForwarded;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
