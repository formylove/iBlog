package main.src.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeManager {

	public static String getDate(){
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static String  getTime(){
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}
	public static int getAge(Date from,Date to){
			int age = 0;
			Calendar born = Calendar.getInstance();
			Calendar now = Calendar.getInstance();
			if (from != null) {
			now.setTime(to);
			born.setTime(from);
			if (born.after(now)) {
			throw new IllegalArgumentException(
			"Can't be born in the future");
			}
			age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR) + 1;
			if (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)) {
			age -= 1;
			}
			}
			return age;
			}
	
	public static void main(String[] args){
		
		System.out.println(TimeManager.getDate());
		System.out.println(TimeManager.getTime());
		
		
	}
}
