package test.tools;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Random;

import org.springframework.util.StringUtils;

import main.src.common.Log;
import main.src.entity.Note;

public class testRandom {

	public testRandom() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Random ran = new Random();
		//0-3 ≤ªª·÷ÿ∏¥
		Log.print("nextInt",ran.nextInt(4));
		Log.print("nextInt",ran.nextInt(4));
		Log.print("nextBoolean",ran.nextBoolean());
		Log.print("nextGaussian",ran.nextGaussian());
		int c = 0;
		for(int i=0;i<1000;i++){
			if(ran.nextBoolean()){
				c++;
			}
		}
		Log.print(c);


		
	}
}
