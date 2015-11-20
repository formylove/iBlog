package test.tools;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

import org.springframework.util.StringUtils;

import main.src.common.Log;
import main.src.entity.Note;

public class testMath {

	public testMath() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Log.print("pi", Math.PI);
		Log.print("abs", Math.abs(-3.33));
		Log.print("negate", Math.negateExact(9));
		Log.print("ceil", Math.ceil(3.2));
		Log.print("floor", Math.floor(3.9));
		Log.print("round", Math.round(5.4));
		Log.print("round", Math.round(5.5));
		Log.print("rint", Math.rint(3.2));
		Log.print("rint", Math.rint(3.5));
		Log.print("sqrt", Math.sqrt(81));
		Log.print("pow", Math.pow(3, 4));
		Log.print("pow", Math.pow(3, 4));
		Log.print("add", Math.addExact(3,4));
		Log.print("min", Math.min(4, 8));
		Log.print("random", Math.random());
		//3 - 17 = rand*step + offset
		Log.print("random", Math.floor(Math.random()*14) + 3);
		int t;
		int c = 0;
		for(int i=0;i<10000;i++){
			t = (int) (Math.floor(Math.random()*14) + 3);
			if(t == 3){
				c++;
			}
		}
		Log.print("appearence", c/10000.0);
		Log.print("appearence", 1/14.0);
		//生女孩期望值
		double sum = 0;
		for(int i=2;i<100;i++){
			sum += Math.pow(0.5, i) * (i-1); 
		}
		Log.print("生女孩期望值",sum);



		
	}
}
