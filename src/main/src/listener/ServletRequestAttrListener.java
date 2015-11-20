package main.src.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class ServletRequestAttrListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
//		System.out.println("request add#" + event.getName() + " : " + event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
//		System.out.println("request remove#" + event.getName() + " : " + event.getValue());
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
//		System.out.println("request change#" + event.getName() + " : " + event.getValue());
		
	}

}
