package main.src.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;



public class FileUtils {
	static public String baseRealPath = ((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/");
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
		saveObj.flush();
		saveObj.close();
		
		return localName;
	}
	
	static public String getFileSuffix(String org_name) throws IOException{
		 return org_name.substring(org_name.lastIndexOf("."), org_name.length());
	 }
	static public void delete(String path){
		File file = new File(path);
		file.deleteOnExit();
	}
	static public void deleteFile(String RelPath){
		delete(baseRealPath+RelPath);
	}
}
