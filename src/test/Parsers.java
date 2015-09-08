package test;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.StringFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.Span;
import org.htmlparser.util.NodeList;
import org.htmlparser.*;
public class Parsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String url = "http://zhidao.baidu.com/link?url=-7sa4H5CM_w_CdzoDyphTwqUTRZQairTwIio2KxKDxog-ioh08MxARde7EOB4FLDdh9a_vhUlA7jRa9hvkF7Sliq_EGm-QJ_zjMI4meNM-q";
String url2 = "http://zhidao.baidu.com/link?url=WtzIP-0dewQcdCNT1vwahKMIRwz6nq1r_ecZvwOlGyLG7Rtxqop8WWqxNPtbvWuH75-maaZzrEX17O2QT0wriK";
try{
Parser parser = new Parser((HttpURLConnection)(new URL(url)).openConnection());
	NodeFilter preFilter = new TagNameFilter("div");
	NodeFilter strFilter = new StringFilter("best-text mb-10");
	NodeFilter classFilter = new HasAttributeFilter("class","line content");
	NodeFilter tagFilter = new TagNameFilter("span");
	NodeFilter attrFilter = new HasAttributeFilter("class","ask-title ");
	@SuppressWarnings("unused")
	NodeFilter filter = (NodeFilter) new AndFilter(tagFilter, attrFilter);
	NodeList nodes = parser.extractAllNodesThatMatch(filter);
	System.out.println("xx");
	print(nodes);
}catch(Exception e){
	
}
	}
static public void print(NodeList nodes){
	int i = 0;
	System.out.println("toPlainTextString: "+nodes.toNodeArray()[i].toPlainTextString());
	System.out.println("toHtml: "+nodes.toNodeArray()[i].toHtml());
	System.out.println("getText: "+nodes.toNodeArray()[i].getText());
	System.out.println("toString: "+nodes.toNodeArray()[i].getFirstChild().getText());
}
}
