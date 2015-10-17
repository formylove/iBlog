package main.src.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import main.src.common.Log;

public class RequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		ServletRequest request = event.getServletRequest();
		// TODO Auto-generated method stub
//		Log.print("request created");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
//		Log.print("request destroyed");
	}
}
