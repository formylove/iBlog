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

public class CNBlogs extends Essay {
	//页面解析参数
	private Parser parser;
	private NodeList nodes;
	public CNBlogs(String url){
		//初始化
		super();//必须放在第一句
		setCategory(5008);
		setOriginal_flag(false);
		setMusic(0);
		setContent(" ");
		setAuthority(10);
		setDel_flag(false);
		setOriginal_link(url);
		setAuthor("CNBlog");
		setLabel("CNBlog");
		setAuthor_link("http://www.cnblogs.com/");
		try {
			HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			parser = new Parser(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parseTitle();
		
	};
	private String parseTitle(){
		NodeFilter tagFilter = new TagNameFilter("title");
		parser.reset();
		try {
			nodes = parser.extractAllNodesThatMatch(tagFilter);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			title = nodes.toNodeArray()[0].toPlainTextString().replace(" - 博客园", "");
			System.out.println("title :"+title);
		return title;
	}

	public String toString(){
		return "id: " + id + "\n" + "title: " + title + "\n" + "subtitle: " + subtitle + "\n" + "profile: " + profile + "\n" + "author: " + author + "\n" + "portrait: " + portrait
				+ "\n" + "author_link: " + author_link + "\n" + "author_desc: " + author_desc + "\n" + "label: " + label + "\n" + "category: " + category + "\n" + "id: " + id + "\n" + "read_cnt: " + read_cnt
				+ "\n" + "favor_cnt: " + favor_cnt + "\n" + "original_flag: " + original_flag + "\n" + "original_link: " + original_link + "\n" + "create_date: " + create_date
				+ "\n" + "create_time: " + create_time + "\n" + "del_flag: " + del_flag;
	}
}
