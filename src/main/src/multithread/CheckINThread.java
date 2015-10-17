package main.src.multithread;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.src.common.SqlUtils;
import main.src.entity.Record;

public class CheckINThread extends Thread {
	HttpServletRequest request;
	public CheckINThread(HttpServletRequest request){
		setRequest(request);
	}
	@Override
	public void run() {
		HttpSession session = request.getSession();
		Record record = new Record(request);
		SqlUtils.executeInsert(record);
		if(session == null){
			session = request.getSession();
			if(session != null){
				session.setAttribute("notFirst", "true");
			}
		}else{
			session.setAttribute("notFirst", "true");
		}
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
