package main.src.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;



public class MusicUtils {
	static public String baseRealPath = ((HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST)).getRealPath("/");
	static public String musicDepot = MessageUtils.getMessageFromUrl("music.depot");
	
	static public String save(File music,String type) throws IOException{
		UUID newName = UUID.randomUUID();
		String path = baseRealPath + musicDepot;
		if(music != null){
			FileUtils.saveFile(music, newName + type, path);
		}
		return newName.toString();
	}
	static public void delete(String musicName){
		if(StringUtils.isNotEmpty(musicName)){
			String path = baseRealPath + musicDepot;
			File file = new File(path + musicName);
			file.deleteOnExit();
		}
	}
	static public String getRealPath(String musicName){
		String path = baseRealPath + musicDepot;
		return path + musicName;
	}
}
