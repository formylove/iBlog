package main.src.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StrUtils {
	static final String MAIL_REG ="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"; 
	static final String Name_REG ="^[0-9a-zA-Z\\u4E00-\\u9FA5_]+$"; 
	static final String SIMPLE_REG ="^[0-9a-zA-Z_]+$"; 
static public String removeTag(String raw){
	if(!isEmpty(raw)){
		raw = raw.replaceAll("&lt;img.+?&gt;","").replaceAll("<img.+?>","").replaceAll("&lt;b&gt;","").replaceAll("<b>","").replaceAll("&lt;/b&gt;","").replaceAll("</b>","").replaceAll("&lt;br&gt;","").replaceAll("<\\s*br\\s*>","").replaceAll("<\\s*br\\s*/>","").replaceAll("<p>","").replaceAll("</p>","").replaceAll("&nbsp;","").replaceAll("<span[^>]*>","").replaceAll("</span>","").trim();
		return raw;
	}else{
		return " ";
	}
}
static public boolean isEmpty(String raw){
	return (raw==null || "".equals(raw));
}
static public boolean contains(String raw,String[] params){
	for(String param : params){
		if(StringUtils.contains(raw, param)){
			return true;
		}
	}
	return false;
}
static public boolean valiPhone(String phone){
	boolean p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$").matcher(phone).matches();  
	return p;
}
static public String fileToString(String filePath){
	String line = "";
	StringBuffer sb = new StringBuffer();
	try {
	BufferedReader br = new BufferedReader(new FileReader(filePath));
	while(null != (line = br.readLine())){
		sb.append(line);
	}
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sb.toString();
}
static public boolean notEmpty(String raw){
	return (raw!=null && !"".equals(raw));
}
static public boolean valiEmail(String email){
	return Pattern.compile(MAIL_REG).matcher(email).matches();
}
static public boolean valiName(String input){
	return Pattern.compile(Name_REG).matcher(input).matches();
}
static public boolean simpleChar(String input){
	return Pattern.compile(SIMPLE_REG).matcher(input).matches();
}
static public boolean url(String input){
	return Pattern.compile(SIMPLE_REG).matcher(input).matches();
}

static public String truncate(String raw,int cnt){
	if(!isEmpty(raw)){
		if(raw.length()>cnt){
			raw = raw.substring(0,cnt-1) + "...";
		}
	}
	return raw;
}
static public String zeroFill(int raw_num,int length){
	String raw = (String.valueOf(raw_num));
	int org_length=raw.length();
	for(int i = 0;i< length - org_length;i++){
		raw = "0" + raw; //+=要练起来的！！！,而且加载了右边
	}
	return raw;
}
static public void main(String[] a){
	
	System.out.println(zeroFill(15,4));
}
}