package main.src.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class StringUtils {
	static final String MAIL_REG ="\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"; 
	static final String Name_REG ="^[0-9a-zA-Z\\u4E00-\\u9FA5_]+$"; 
	static final String SIMPLE_REG ="^[0-9a-zA-Z]+$"; 
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
		raw = "0" + raw; //+=Ҫ�������ģ�����,���Ҽ������ұ�
	}
	return raw;
}
static public void main(String[] a){
	
	System.out.println(zeroFill(15,4));
}
}