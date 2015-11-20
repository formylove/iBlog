package test.tools;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

public class testCmd {

	public testCmd() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		long initUsedMemory = ( Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() ) ;
		Runtime run = Runtime.getRuntime();   
		  String cmdStr = "cmd /c start dir" ;
		  String cmdStr2 = "cmd d:/fs.txt" ;
	      run.exec(cmdStr2);
	      Process process = run.exec("calc");   
	            InputStream in = process.getInputStream();     
	            while (in.read() != -1) {   
	                System.out.println(in.read());   
	            }   
	            in.close();   
	}

}
