package main.src.entity.essay;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.StringFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import main.src.common.Spider;

public class Zhidao extends Essay {
	//页面解析参数
	private Parser parser;
	private NodeList nodes;
	static private final String contentReg = "(?<=class=\"best-text mb-10\">).*?(?=</pre>)";
	static private final String author_linkReg = "(?<=href=\")[^\"]*(?=\")";
	static private final String portraitReg = "(?<= data-img=\")[^\"]*(?=\")";
	static private final String subtitleReg = "(?<=accuse=\"qContent\">).*?(?=</pre>)";
	public Zhidao(String url){
		//初始化
		super();//必须放在第一句
		setCategory(5003);
		setOriginal_flag(false);
		setMusic(0);
		setAuthority(10);
		setDel_flag(false);
		setOriginal_link(url);
		try {
			HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			parser = new Parser(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parseTitle();
		parseSubtitle();
		parseContent();                     
		parseAuthorDetail();                     
		parseAuthor_desc();
		parseAuthor();
		parseLabel();
		
	};
	private String parseTitle(){
		NodeFilter tagFilter = new TagNameFilter("span");
		NodeFilter attrFilter = new HasAttributeFilter("class","ask-title ");
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		try {
			parser.reset();
			nodes = parser.extractAllNodesThatMatch(filter);
			title = nodes.toNodeArray()[0].toPlainTextString();
			System.out.println("title :"+title);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	private String parseLabel(){
		NodeFilter tagFilter = new TagNameFilter("a");
		NodeFilter attrFilter = new HasAttributeFilter("class","question-tag-link");
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		try {
			parser.reset();
			label = "";
			nodes = parser.extractAllNodesThatMatch(filter);
			for(int i=0;i<nodes.size();i++){
				label =  nodes.elementAt(i).toPlainTextString() + ";" + label ;
			}
			label = label.trim().replaceAll("(\t\n|\n\t|\n|\t)", " ");
			System.out.println("label :"+label);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return label;
	}
	
	private String parseContent(){
		NodeFilter tagFilter = new TagNameFilter("div");
		NodeFilter classFilter = new HasAttributeFilter("class","line content");
		@SuppressWarnings("unused")
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, classFilter);
		String fatherNode = "";
		try {
			parser.reset();//调用一次后需要reset归位
			fatherNode = parser.extractAllNodesThatMatch(filter).toNodeArray()[0].toHtml();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Matcher match = Pattern.compile(contentReg).matcher(fatherNode);
		if(match.find()){
			content = match.group();
		}
		System.out.println("content :"+content);
		return content;
	}
	
	private String parseSubtitle(){
		NodeFilter tagFilter = new TagNameFilter("div");
		NodeFilter attrFilter = new HasAttributeFilter("id","wgt-ask");
		@SuppressWarnings("unused")
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		String fatherNode = "";
		try {
			parser.reset();//调用一次后需要reset归位
			fatherNode = parser.extractAllNodesThatMatch(filter).toNodeArray()[0].toHtml();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Matcher match = Pattern.compile(subtitleReg).matcher(fatherNode);
		if(match.find()){
			subtitle = match.group();
		}
		System.out.println("subtitle :"+subtitle);
		return subtitle;
	}
	
private String parseAuthorDetail(){
	NodeFilter tagFilter = new TagNameFilter("a");
	NodeFilter attrFilter = new HasAttributeFilter("alog-action","qb-username");
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	try {
		parser.reset();
		nodes = parser.extractAllNodesThatMatch(filter);
		Matcher matcher = Pattern.compile(author_linkReg).matcher(nodes.toNodeArray()[0].toHtml());
		if(matcher.find()){
			author_link = matcher.group();
		}
		  matcher = Pattern.compile(portraitReg).matcher(nodes.toNodeArray()[0].toHtml());
		  if(matcher.find()){
			  portrait = matcher.group();
		  }
		
		System.out.println("author_link :"+author_link);
		System.out.println("portrait :"+portrait);
	} catch (ParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return author;
}
private String parseAuthor_desc(){
	NodeFilter tagFilter = new TagNameFilter("p");
	NodeFilter attrFilter = new HasAttributeFilter("class","carefield");
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	try {
		parser.reset();
		author_desc = "";
		nodes = parser.extractAllNodesThatMatch(filter);
		if(nodes != null && nodes.size()>0){
			for(int i=0;i<nodes.toNodeArray()[0].getChildren().size();i++){
				author_desc = author_desc + nodes.toNodeArray()[0].getChildren().elementAt(i).toPlainTextString();
			}
		}
		author_desc = author_desc.trim().replaceAll("(\t\n|\n\t|\n|\t)", " ");
		System.out.println("author_desc :"+author_desc);
	} catch (ParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return author_desc;
}
@SuppressWarnings("unused")
private String parseAuthor(){
		Matcher matcher = Pattern.compile("(?<=/)[^?/]*(?=\\?)").matcher(author_link);
		if(matcher.find()){
			author = matcher.group();
		}
		System.out.println("author :"+author);
	
	return author;
}
	public String toString(){
		return "id: " + id + "\n" + "title: " + title + "\n" + "subtitle: " + subtitle + "\n" + "profile: " + profile + "\n" + "author: " + author + "\n" + "portrait: " + portrait
				+ "\n" + "author_link: " + author_link + "\n" + "author_desc: " + author_desc + "\n" + "label: " + label + "\n" + "category: " + category + "\n" + "id: " + id + "\n" + "read_cnt: " + read_cnt
				+ "\n" + "favor_cnt: " + favor_cnt + "\n" + "original_flag: " + original_flag + "\n" + "original_link: " + original_link + "\n" + "create_date: " + create_date
				+ "\n" + "create_time: " + create_time + "\n" + "del_flag: " + del_flag;
	}
}
