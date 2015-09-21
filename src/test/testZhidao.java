/**
 * 
 */
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.src.entity.essay.CNBlogs;
import main.src.entity.essay.CSDN;
import main.src.entity.essay.Douban;
import main.src.entity.essay.ITEye;
import main.src.entity.essay.Zhidao;
import main.src.service.EssayService;

/**
 * @author Administrator
 *
 */
public class testZhidao {
 static public void main(String args[]) throws IOException{
	 String url = "http://zhidao.baidu.com/link?url=-7sa4H5CM_w_CdzoDyphTwqUTRZQairTwIio2KxKDxog-ioh08MxARde7EOB4FLDdh9a_vhUlA7jRa9hvkF7Sliq_EGm-QJ_zjMI4meNM-q";
	 String url2 = "http://zhidao.baidu.com/question/527326017.html?fr=iks&word=%D4%B1%CD%E2%C0%C9&ie=gbk";
	 String url3 = "http://zhidao.baidu.com/question/1702337066530621140.html?fr=iks&word=%D0%A1%C3%D7&ie=gbk";
	 String url4 = "http://movie.douban.com/review/6716390/";
	 String url5 = "http://book.douban.com/review/7595674/?icn=index-reviewer";
	 String url6 = "http://www.douban.com/note/413145196/";
//	 CSDN c = new CSDN(url4);	
	 Douban z = new Douban(url4);
 }
}
