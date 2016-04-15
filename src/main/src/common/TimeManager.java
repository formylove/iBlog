package main.src.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeManager {
	public static SimpleDateFormat fullFormatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat dayFormatter=new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat timeFormatter=new SimpleDateFormat("HH:mm");
	public static String getDate(){
		Date date=new Date();
		
		return dayFormatter.format(date);
	}
	public static Date transformToDate(String date){
		Date d = null;
		try {
			d = dayFormatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public static String  getTime(){
		Date date=new Date();
		return timeFormatter.format(date);
	}
	public static String  getTimeDif(String day,String time){
		Date full = null;
		try {
			full = fullFormatter.parse(day + " " + time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  getTimeDif(full);
	}
	public static String getTimeDif(Date full){
		int age = 0;
		Date date=new Date();
		Calendar born = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		born.setTime(full);
		
		int yearDif = now.get(Calendar.YEAR) - born.get(Calendar.YEAR)
		- (now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)?1:0);
		if (yearDif > 0) {
			return yearDif+"年前";
		}

		int monthDif = now.get(Calendar.MONTH) - born.get(Calendar.MONTH)
				- (now.get(Calendar.DAY_OF_MONTH) < born.get(Calendar.DAY_OF_MONTH)?1:0);
		if(now.get(Calendar.YEAR) != born.get(Calendar.YEAR)){
			monthDif += 12;
		}
		if ( monthDif > 0) {
			return monthDif+"个月前";
		} 
		
		
		int dayDif = now.get(Calendar.DAY_OF_YEAR) - born.get(Calendar.DAY_OF_YEAR)
				- (now.get(Calendar.HOUR_OF_DAY) < born.get(Calendar.HOUR_OF_DAY)?1:0);
		if(now.get(Calendar.YEAR) != born.get(Calendar.YEAR)){
			dayDif += born.getActualMaximum(Calendar.DAY_OF_YEAR);//一年总天数
		}
		if ( dayDif > 7) {
			return dayDif/7+"个星期前";
		} 
		if ( dayDif > 0) {
			return dayDif+"天前";
		} 
		
		int hourDif = now.get(Calendar.HOUR_OF_DAY) - born.get(Calendar.HOUR_OF_DAY)
				- (now.get(Calendar.MINUTE) < born.get(Calendar.MINUTE)?1:0);
		if(now.get(Calendar.DAY_OF_YEAR) != born.get(Calendar.DAY_OF_YEAR)){
			hourDif += 24;
		}
		if ( hourDif > 0) {
			return hourDif+"小时前";
		} 
		
		int minuteDif = now.get(Calendar.MINUTE) - born.get(Calendar.MINUTE)
				- (now.get(Calendar.SECOND) < born.get(Calendar.SECOND)?1:0);
		if(now.get(Calendar.HOUR) != born.get(Calendar.HOUR)){
			minuteDif += 60;
		}
		if ( minuteDif > 0) {
			return minuteDif+"分钟前";
		} 
			return "刚刚";
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
