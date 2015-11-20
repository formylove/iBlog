package test.tools;

import java.nio.charset.Charset;

import main.src.common.IPParser;
import main.src.common.Log;

public class testEncoding {

	public static void main(String[] args) throws Exception {
		IPParser i = new IPParser("222.49.167.90",true);
		String OSCoding = System.getProperty("file.encoding");
		String defaultCharsetName=Charset.defaultCharset().displayName(); 
		Log.print("encoding-system", OSCoding);
		Log.print("encoding-java", defaultCharsetName);
		Log.print("country", new String(i.getCountry().getBytes(defaultCharsetName),"utf-8"));
		Log.print("local", new String(i.getLocal().getBytes(defaultCharsetName),"utf-8"));
	}

}
