package test.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

import org.springframework.util.StringUtils;

import main.src.common.Log;
import main.src.entity.Note;

public class testProperties {

	public testProperties() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("d:/common.properties");
		Properties p = new Properties();
		p.load(fis);
		Log.print("fis2pro", p.get("common.login"));
		Log.print("fis2pro", p.getProperty("common.login"));
		Log.print("default", p.getProperty("common.logi","no term"));
		p.setProperty("common.reg", "register");
		p.put("common.logout", "logout");
//		Note note = new Note();
//		note.author="雨果";
//		p.put("note", note);
//		//导出对象
//		Log.print("author", ((Note)p.get("note")).author);
		p.save(System.out, "save");
		p.store(System.out,"store");
		p.list(System.out);
		//全部导出
	    PrintStream fw = new PrintStream(new File("d:\\p.properties"));
	    p.store(fw,"output file");
	    //xml读取
	    p.clear();
		FileInputStream fis2 = new FileInputStream("d:/x.xml");
		p.loadFromXML(fis2);
		p.store(System.out,"xml reader");
		//获取系统properties
		p = System.getProperties();
		//删除term
		p.remove("java.runtime.name");
		//获取系统properties names
		for(String s:p.stringPropertyNames()){
			System.out.println(s);
		}
		p.store(System.err,"system properties");
	}

}
