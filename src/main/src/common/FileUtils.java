package main.src.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;



public class FileUtils {

	static public String saveFile(File file,String localName,String path) throws IOException{
		InputStream img=new FileInputStream(file);
		File local=new File(path,localName);
		OutputStream saveObj=new FileOutputStream(local);
		int length=0;
		byte[] buffer=new byte[1024];
		while((length=img.read(buffer))>0){
			saveObj.write(buffer, 0, length);
		}
		img.close();
		saveObj.close();
		
		return localName;
	}
	
	static public String saveFile(File file,String path) throws IOException{
		String localName=UUID.randomUUID().toString();
		return saveFile(file, localName, path);
	}
	
}
