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
static public boolean notEmpty(String raw){
	return (raw!=null && !"".equals(raw));
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