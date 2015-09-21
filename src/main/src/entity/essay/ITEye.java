package main.src.entity.essay;

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

public class ITEye extends Essay {
	//页面解析参数
	private Parser parser;
	private NodeList nodes;
	static private final String contentReg = "(?<=class=\"article_content\">).*?(?=</div>)";
	static private final String portraitReg = "(?<=src=\")[^\"]*(?=\")";
	static private final String author_linkReg = "(?<=href=\')[^\"]*(?=\')";
	static private final String authorReg = "(?<=blog_owner_name\">).*?(?=</div>)";
	public ITEye(String url){
		//初始化
		super();//必须放在第一句
		setCategory(5009);
		setOriginal_flag(false);
		setMusic(0);
		setContent(" ");
		setAuthority(10);
		setDel_flag(false);
		setOriginal_link(url);
		setLabel("ITEye");
		try {
			HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			parser = new Parser(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parseTitle();
		parseAuthorDetail();                     
		parseLabel();
		
	};
	private String parseTitle(){
		NodeFilter tagFilter = new TagNameFilter("title");
		try {
			parser.reset();
			nodes = parser.extractAllNodesThatMatch(tagFilter);
			title = nodes.toNodeArray()[0].toPlainTextString();
			title = title.substring(0, title.indexOf(" -"));
			System.out.println("title :"+title);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	private String parseLabel(){
		NodeFilter tagFilter = new TagNameFilter("ul");
		NodeFilter attrFilter = new HasAttributeFilter("class","blog_categories");
		NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
		try {
			parser.reset();
			label = "";
			nodes = parser.extractAllNodesThatMatch(filter);
			String l = "";
			if(nodes.size()>0){
			for(int i=0;i<nodes.elementAt(0).getChildren().size();i++){
				l =  nodes.elementAt(0).getChildren().elementAt(i).toPlainTextString().trim();
				if("".equals(l) || l.indexOf("博客分类")>=0){
					continue;
				}else{
					label = l + ";" + label ;
				}
			}
			}
			label = label.trim().replaceAll("(\t\n|\n\t|\n|\t)", " ").substring(0, label.length()-1);
			System.out.println("label :"+label);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return label;
	}
	
	private String parseContent(){
		boolean noConten = true;
		if(noConten){
		content = " ";
		}else{
			NodeFilter tagFilter = new TagNameFilter("div");
			NodeFilter attrFilter = new HasAttributeFilter("id","article_content");
			NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
			try {
				parser.reset();//调用一次后需要reset归位
				content = parser.extractAllNodesThatMatch(filter).toNodeArray()[0].toPlainTextString();
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Matcher match = Pattern.compile(contentReg).matcher(content);
			if(match.find()){
				content = match.group();
			}
			System.out.println("content :"+content);
		}
		return content;
	}
	

private String parseAuthorDetail(){
	NodeFilter tagFilter = new TagNameFilter("div");
	NodeFilter attrFilter = new HasAttributeFilter("id","blog_owner");
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
		
		System.out.println("author_link :"+author_link);
		System.out.println("author :"+author);
		System.out.println("portrait :"+portrait);
	} catch (ParserException e) {
		// TODO Auto-generated catch block
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
