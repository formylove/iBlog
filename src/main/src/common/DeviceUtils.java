package main.src.common;

import java.util.regex.Pattern;

public class DeviceUtils {
	static private final String MI_REG = "$MI^"; 
	private final String XiaoMi = "小米手机"; 
static public String getDeviceName(String agent){
	return getBrowserName(agent) + " " + getBrowserVersion(agent);
}
static public String getBrowserName(String agent){
	
	if(Pattern.compile(MI_REG).matcher(agent).find()){
		
	}else if(Pattern.compile(MI_REG).matcher(agent).find()){
		
		
	}else if(Pattern.compile(MI_REG).matcher(agent).find()){
		
		
	}else if(Pattern.compile(MI_REG).matcher(agent).find()){
		
		
	}else if(Pattern.compile(MI_REG).matcher(agent).find()){
		
		
	}else if(Pattern.compile(MI_REG).matcher(agent).find()){
		
		
	}
	
	return null;
}
static public String getBrowserVersion(String agent){
	
	return null;
}
}
