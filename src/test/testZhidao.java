/**
 * 
 */
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;

import main.src.entity.essay.CSDN;
import main.src.entity.essay.Zhidao;

/**
 * @author Administrator
 *
 */
public class testZhidao {
 static public void main(String args[]) throws IOException{
	 String url = "http://zhidao.baidu.com/link?url=-7sa4H5CM_w_CdzoDyphTwqUTRZQairTwIio2KxKDxog-ioh08MxARde7EOB4FLDdh9a_vhUlA7jRa9hvkF7Sliq_EGm-QJ_zjMI4meNM-q";
	 String url2 = "http://zhidao.baidu.com/question/527326017.html?fr=iks&word=%D4%B1%CD%E2%C0%C9&ie=gbk";
	 String url3 = "http://zhidao.baidu.com/question/1702337066530621140.html?fr=iks&word=%D0%A1%C3%D7&ie=gbk";
	 String url4 = "http://blog.csdn.net/zhengqiqiqinqin/article/details/12621201";
	 String url5 = "http://blog.csdn.net/lovecluo/article/details/7894492";
	 CSDN c = new CSDN(url4);	 

 }
 static void print(Zhidao z){
	 System.out.println(z.getTitle());
	 System.out.println(z.getContent());
	 
 }
}
