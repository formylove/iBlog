package main.src.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener{
	public HttpServletRequest request;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession  session = (HttpSession)event.getSession();
		// TODO Auto-generated method stub
		System.out.println("session " + session.getId() + " created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		HttpSession  session = (HttpSession)event.getSession();
		System.out.println("session " + session.getId() + " detroyed");
	}

	
}
