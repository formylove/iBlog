package test.tools;

import java.util.Calendar;
import java.util.Date;

import main.src.common.Log;

public class testDate {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Log.print("现在日期", cal.get(Calendar.DAY_OF_YEAR));
		cal.set(Calendar.DAY_OF_YEAR, cal.get(Calendar.DAY_OF_YEAR)+ 1);
		Log.print("明天日期", cal.get(Calendar.DAY_OF_YEAR));
	}

}
