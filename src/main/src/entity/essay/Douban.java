package main.src.entity.essay;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import main.src.common.TxtFileUtils;

public class Douban extends Essay {
	//页面解析参数
	private Parser parser;
	private NodeList nodes;
	static private final String contentReg = "(?<=class=\"article_content\">).*?(?=</div>)";
	static private final String portraitReg = "(?<=src=\")[^\"]*(?=\")";
	static private final String author_linkReg = "(?<=href=\")[^\"]*(?=\")";
	static private final String authorReg = "(?<=alt=\").*?(?=\")";
	static private final String author_movie_bookReg = "(?<=<span property=\"v:reviewer\">).*?(?=</span>)";
	static private final String author_descReg = "(?<=</a>).*?(?=<br/>)";
	public Douban(String url){
		//初始化
		super();//必须放在第一句
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
		if(url.indexOf("douban.com/note")>=0){
			setCategory(5008);
			parseAuthorDetailFromNote();                     
			
		}else if(url.indexOf("movie.douban.com/review")>=0){
			parseAuthorDetailFromMovie();                     
			setCategory(5010);
		}else if(url.indexOf("book.douban.com/review")>=0){
			parseAuthorDetailFromBook();                     
			setCategory(5009);
		}
		parseTitle();
		parseContent();                     
		parseLabel();
		
	};
	private String parseTitle(){
		NodeFilter tagFilter = new TagNameFilter("title");
		try {
			parser.reset();
			nodes = parser.extractAllNodesThatMatch(tagFilter);
			title = nodes.toNodeArray()[0].getFirstChild().toPlainTextString().trim();
			System.out.println("title :"+title);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	private String parseLabel(){
		NodeFilter tagFilter = new TagNameFilter("div");
		NodeFilter attrFilter = new HasAttributeFilter("class","tag2box");
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		try {
			parser.reset();
			label = "";
			nodes = parser.extractAllNodesThatMatch(filter);
			String l = "";
			if(nodes.size()>0){
			for(int i=0;i<nodes.elementAt(0).getChildren().size();i++){
					label = nodes.elementAt(0).getChildren().elementAt(i).toPlainTextString().trim()  + ";" + label ;
			}
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
			NodeFilter attrFilter = new HasAttributeFilter("id","link-report");
			NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
			try {
				parser.reset();//调用一次后需要reset归位
				content = parser.extractAllNodesThatMatch(filter).toNodeArray()[0].toHtml().replaceAll("((\t\n)|(\n\t)|\n|\t)", "");
				content = content.replace("<div[^>]*?id=\"link-report\"[^>]*?>", "").substring(0, content.lastIndexOf("</div>"));
				TxtFileUtils.writeTo(content, "fs");
				System.out.println("content :"+content);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return content;
	}
	

private String parseAuthorDetailFromNote(){
	NodeFilter tagFilter = new TagNameFilter("div");
	NodeFilter attrFilter = new HasAttributeFilter("class","mod mod-usercard");
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	try {
		parser.reset();
		nodes = parser.extractAllNodesThatMatch(filter);
		String author_detail = nodes.toNodeArray()[0].toHtml();
		Matcher matcher = Pattern.compile(portraitReg).matcher(author_detail);
		if(matcher.find()){
			portrait = matcher.group();
		}
		  matcher = Pattern.compile(author_linkReg).matcher(author_detail);
		  if(matcher.find()){
			  author_link = matcher.group();
		  }
		  
		  matcher = Pattern.compile(authorReg).matcher(author_detail);
		  if(matcher.find()){
			  author = matcher.group();
		  }
		  
		  matcher = Pattern.compile(author_descReg).matcher(author_detail);
		  if(matcher.find()){
			  author_desc = matcher.group();
		  }
		
		System.out.println("author_link :"+author_link);
		System.out.println("author :"+author);
		System.out.println("portrait :"+portrait);
		System.out.println("author_desc :"+author_desc);
	} catch (ParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return author;
}
private String parseAuthorDetailFromMovie(){
	NodeFilter tagFilter = new TagNameFilter("div");
	NodeFilter attrFilter = new HasAttributeFilter("class","main-hd");
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	try {
		parser.reset();
		nodes = parser.extractAllNodesThatMatch(filter);
		String author_detail = nodes.toNodeArray()[0].toHtml();
		Matcher matcher = Pattern.compile(portraitReg).matcher(author_detail);
		if(matcher.find()){
			portrait = matcher.group();
		}
		matcher = Pattern.compile(author_linkReg).matcher(author_detail);
		if(matcher.find()){
			author_link = matcher.group();
		}
		
		matcher = Pattern.compile(author_movie_bookReg).matcher(author_detail);
		if(matcher.find()){
			author = matcher.group();
		}
		
		matcher = Pattern.compile(author_descReg).matcher(author_detail);
		if(matcher.find()){
			author_desc = matcher.group();
		}
		
		System.out.println("author_link :"+author_link);
		System.out.println("author :"+author);
		System.out.println("portrait :"+portrait);
		System.out.println("author_desc :"+author_desc);
	} catch (ParserException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return author;
}

private String parseAuthorDetailFromBook(){
	NodeFilter tagFilter = new TagNameFilter("div");
	NodeFilter attrFilter = new HasAttributeFilter("class","piil");
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	try {
		parser.reset();
		nodes = parser.extractAllNodesThatMatch(filter);
		String author_detail = nodes.toNodeArray()[0].toHtml();
		Matcher matcher = Pattern.compile(portraitReg).matcher(author_detail);
		if(matcher.find()){
			portrait = matcher.group();
		}
		matcher = Pattern.compile(author_linkReg).matcher(author_detail);
		if(matcher.find()){
			author_link = matcher.group();
		}
		
		tagFilter = new TagNameFilter("span");
		attrFilter = new HasAttributeFilter("class","pl2");
		filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		parser.reset();
		nodes = parser.extractAllNodesThatMatch(filter);
		author_detail = nodes.toNodeArray()[0].toHtml();
		matcher = Pattern.compile(author_movie_bookReg).matcher(author_detail);
		if(matcher.find()){
			author = matcher.group();
		}
		
		matcher = Pattern.compile(author_descReg,Pattern.DOTALL).matcher(author_detail);
		if(matcher.find()){
			author_desc = matcher.group().trim();
		}
		
		System.out.println("author_link :"+author_link);
		System.out.println("author :"+author);
		System.out.println("portrait :"+portrait);
		System.out.println("author_desc :"+author_desc);
	} catch (ParserException e) {		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return author;
}

	public String toString(){
		return "id: " + id + "\n" + "title: " + title + "\n" + "subtitle: " + subtitle + "\n" + "profile: " + profile + "\n" + "author: " + author + "\n" + "portrait: " + portrait
				+ "\n" + "author_link: " + author_link + "\n" + "author_desc: " + author_desc + "\n" + "label: " + label + "\n" + "category: " + category + "\n" + "id: " + id + "\n" + "read_cnt: " + read_cnt
				+ "\n" + "favor_cnt: " + favor_cnt + "\n" + "original_flag: " + original_flag + "\n" + "original_link: " + original_link + "\n" + "create_date: " + create_date
				+ "\n" + "create_time: " + create_time + "\n" + "del_flag: " + del_flag;
	}
}
