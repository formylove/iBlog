package main.src.common;

public class StringUtils {
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
static public String truncate(String raw,int cnt){
	if(!isEmpty(raw)){
		if(raw.length()>cnt){
			raw = raw.substring(0,cnt-1) + "...";
		}
	}
	return raw;
}
}
