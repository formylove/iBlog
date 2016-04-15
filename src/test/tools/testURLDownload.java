package test.tools;

import java.util.Calendar;
import java.util.Date;

import main.src.common.ImageUtils;
import main.src.common.Log;

public class testURLDownload {

	public static void main(String[] args) {
		System.out.println(ImageUtils.saveImageFromUrl("https://pic2.zhimg.com/e8b6ad13f3a7c770533bba345dca1935_m.jpg"));
	}

}
