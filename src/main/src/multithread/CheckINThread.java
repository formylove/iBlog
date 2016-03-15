package main.src.multithread;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import main.src.entity.Record;
import main.src.service.RecordService;

public class CheckINThread extends Thread{
	RecordService recordService;
	HttpServletRequest request;
	ApplicationContext ctx;
	public CheckINThread(HttpServletRequest request,ApplicationContext ctx){
		setRequest(request);
		setCtx(ctx);
		recordService = ctx.getBean("recordService", RecordService.class);
	}
	@Override
	public void run() {
		HttpSession session = request.getSession(true);
		Record record = new Record(request);
		recordService.save(record);
		session.setAttribute("notFirst", "true");
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

}