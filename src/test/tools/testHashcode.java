package test.tools;

import java.util.Calendar;
import java.util.Date;

import main.src.common.Log;

public class testHashcode {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
//		hashcodeÿ��ֵ��ͬ
		Log.print("hashcode1", cal.hashCode());
		Log.print("hashcode2", cal.hashCode());
	}

}
