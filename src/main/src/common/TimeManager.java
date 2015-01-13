package main.src.common;

import java.text.SimpleDateFormat;
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
	
	public static void main(String[] args){
		
		System.out.println(TimeManager.getDate());
		System.out.println(TimeManager.getTime());
		
		
	}
}
