package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.src.common.Spider;
import main.src.common.TxtFileUtils;
import main.src.entity.essay.Douban;
import main.src.entity.essay.Zhihu;

public class RegExp {
	public static void main(String[] args){
//	String web1 = "http://www.zhihu.com/question/34181871/answer/61108606";
//	String html = Spider.SendGet(web1);
//	String reg = "(?<=<noscript>).*?(?=</noscript>)";
//	String reg2 = "(?<=<div class=\" zm-editable-content clearfix\">).*?(?=<a class=\"zg-anchor-hidden)";
////	String block = getSingleNode(reg2,html);
////	block = block.substring(0, block.lastIndexOf("</div>"));
////	block = block.substring(0, block.lastIndexOf("</div>"));
////	block = block.replaceAll(reg, "");
////	block = block.replaceAll("<noscript></noscript>", "");
//	Zhihu z = new Zhihu(web1);
//	System.out.println(z.getContent());
//	System.out.println(z.getProfile());
		 String url5 = "http://book.douban.com/review/7595674/?icn=index-reviewer";
		 String url6 = "http://www.douban.com/note/413145196/";
//		 CSDN c = new CSDN(url4);	
		 Douban z = new Douban(url5);
		 TxtFileUtils.writeTo(z.content.replaceAll("<div[^>]*?id=\"link-report\"[^>]*?>", ""), "vv");
//		getSingleNode("<div[^>]*?id=\"link-report\"[^>]*?>", "<div id=\"link-report\" class=\"review-text\">  ");
//		System.out.println("vvvvv"+z.content.replaceAll("<div[^>]*?id=\"link-report\"[^>]*?>", ""));
	}
static public String getSingleNode(String regExp,String html){
	Pattern pattern = Pattern.compile(regExp);
	Matcher matcher = pattern.matcher(html);
	boolean b =matcher.find();
	System.out.println(b);
	if(b)
	{
		System.out.println(matcher.group());
		return matcher.group();
	}
	else
	return "";
}
}
