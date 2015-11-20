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

public class testConsole {

	public testConsole() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
	Log.print("nanoTime",System.nanoTime());
	Log.print("currentTimeMillis",System.currentTimeMillis());
	Thread.sleep(5);
	Log.print("lineSeparator",System.lineSeparator());
	//一毫秒等于六次方纳秒
	Log.print("nanoTime-end",System.nanoTime());
	Log.print("currentTimeMillis-end",System.currentTimeMillis());
	
	
	}
}
