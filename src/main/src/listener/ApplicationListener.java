package main.src.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import main.src.common.MsgConstants;
import main.src.common.TimeManager;
import task.StartUpTask;

@WebListener
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out.println("app destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		MsgConstants.init();
		System.out.println("app launches:" + TimeManager.getTime());
		Timer time = new Timer();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 4);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date date = cal.getTime();
		if (date.before(new Date())) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
			date = cal.getTime();
			}

		time.scheduleAtFixedRate(new StartUpTask(), date, 1000*60*60*24);
	}
}
