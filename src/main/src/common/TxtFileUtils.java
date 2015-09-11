package main.src.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileUtils {
static public void write(String content){
	File f = new File("d:/ff.txt");
	try {
		FileWriter o;
		o = new FileWriter(f);
		@SuppressWarnings("resource")
		BufferedWriter oo =new BufferedWriter(o);
		oo.write(content);
		oo.flush();  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
static public void writeTo(String content,String fileName){
	File f = new File("d:/"+fileName+".txt");
	try {
		FileWriter o;
		o = new FileWriter(f);
		@SuppressWarnings("resource")
		BufferedWriter oo =new BufferedWriter(o);
		oo.write(content);
		oo.flush();  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
