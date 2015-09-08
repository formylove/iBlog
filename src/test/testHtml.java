package test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.src.common.Spider;
import main.src.entity.essay.Zhihu;

public class testHtml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String web1 = "http://www.zhihu.com/question/34181871/answer/61108606";
		String web2 = "http://sannahkvist.se/";
		String web3 = "http://blog.csdn.net/huzi111/article/details/6545945";
		String web4 = "http://www.zhihu.com/";
		String web5 = "http://www.zhihu.com/question/34721074/answer/61297948";
//		System.out.println(Spider.SendGet(web5));
		String html = Spider.SendGet(web1);
		Map<String,String> regExp = new HashMap<String,String>();
		regExp.put("title", "<a\\s*href=\"/question/\\d{8}\"\\s*>[^<]+</a>");
		regExp.put("content", "(?<=<noscript>).*(?=</noscript>)");
		regExp.put("label", "<a[^>]*class=\"zm-item-tag\"[^>]*>[^<]*</a>");
		regExp.put("subtitle", "(?<=<textarea class=\"content hidden\">).*(?=</textarea>)");
		regExp.put("people", "(?<=<h3 class=\"zm-item-answer-author-wrap\">).*(?=</h3>)");
		regExp.put("author_link", "(?<=href=\")[^\"]*(?=\")");
		regExp.put("portrait", "(?<=src=\")[^\"]*(?=\")");
		regExp.put("author_desc", "(?<=title=\")[^\"]*(?=\")");
		regExp.put("author", "(?<=>)[^<>]*(?=</a>£¬)");
		regExp.put("profile1", "<img.+?src\\s*=\\s*\"[^\"]+\"[^>]*>");
		regExp.put("profile2", "(?<=src=\")[^\"]*(?=\")");
		getSingleNode("(?<=href=z>)[^f]*(?=f)"," href=zsdfffffffff");
	}
	static public String getSingleNode(String regExp,String html){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(html);
		System.out.println(matcher.find());
		System.out.println(matcher.group());
		return matcher.group();
	}
	static public String getMultiNode(String regExp,String html){
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(html);
		String result = "";
		for(;matcher.find();)
		{
			result = result + ";\n"+ matcher.group();
		}
		return result;
	}
}
