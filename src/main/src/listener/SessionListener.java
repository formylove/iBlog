package main.src.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

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
