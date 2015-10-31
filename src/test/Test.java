package test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import main.src.common.IPParser;
import main.src.common.ImageUtils;
import main.src.common.MailUtils;
import main.src.common.MsgConstants;
import main.src.common.Spider;
import main.src.common.StrUtils;
import main.src.entity.Comment;
import main.src.multithread.CheckINThread;
public class Test {
    /**
     * @param args
     * @throws Exception 
     */
	static private final String Salutation_Reg="(?<=id=\"salutation\">)[^<]+(?=</p>)";
	static private final String Href_Reg = "(?<=href=\")[^\"]*(?=\")";
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
//        System.out.println("Bingo!");
//        Calendar cal=Calendar.getInstance();
//        Date date=new Date();
//        date=cal.getTime();
//        System.out.println(date.getTime());
//        System.out.println(cal.getTimeInMillis());
//        System.out.println(cal.getWeekYear()+"  "+cal.toString());
//        //System.out .rintln(cal.getTime().toString()+"  "+date+"  "+cal);
//        Random ran=new Random();
//        System.out.println(ran.nextFloat()+" "+ran.nextInt()+" "+ran.nextBoolean());
//        System.out.println(ran.nextFloat()+" "+ran.nextInt()+" "+ran.nextBoolean());//可重复
//        System.out .println(Math.random());//Math存在一些函数:pow(power求幂),abs,log,max,sin
//        System.out .println(Math.random());
//        System.out .println(Math.random());//产生0_1小数
//        Map<String, String> nation = MsgConstants.ISO31661ALPHA3;
//    	System.out.println(nation.get("CN"));
//    	System.out.println("wocao?");
//    	Map i =new HashMap<>();
//    	i.put("", "fff");
//    	String imgUrl="http://ww4.sinaimg.cn/bmiddle/d54a1fa7jw1ew9wd40pxdj218g0p044p.jpg";
//    	ImageUtils.saveImageFromUrl(imgUrl);
//    	System.out.println(Pattern.compile("\\w+").matcher("sadf3ww3dfg45645").matches());
//    	System.out.println(StringUtils.valiEmail("1@e."));
//    	System.out.println(StringUtils.valiName("a哈啊哈sdfas_fsadf"));
//    	System.out.println("iiii,,f,,,".replaceAll(",+$", ""));
    	IPParser i = new IPParser();
    	i.seek("221.131.128.201");
    	System.out.println(i.getCountry());
//    	String html = Spider.SendGet("http://ip.taobao.com/service/getIpInfo.php?ip=122.95.231.214");
//    	
//    	System.out.println(html);
//    	System.out.println(decodeUnicode("\u4e2d\u56fd"));
//    	MailUtils m = new MailUtils();
//    	m.sendEmail("satan199@163.com", "hi", "<a href='baidu.com'>hello</a>");
//    	String content = StringUtils.fileToString("d://d.txt");
//    System.out.println(content);
//    System.out.println("0>        <p id=\"salutation\">XX, 感谢你注册夜网</p> ".replaceAll(Salutation_Reg, "xuyang, 感谢你注册夜网"));
    
    
//    	String url="http://api.91cha.com/ip?key=e7cd6cbceca6415bb7817f913162ef39&ip=122.95.231.214";//    	CheckINThread ct = new CheckINThread("122.95.231.214");
//    			ct.start();
//    	System.out.println("go!");
    }
    public static String decodeUnicode(final String ascii) {   
    	    int n = ascii.length() / 6;  
    	    StringBuilder sb = new StringBuilder(n);  
    	    for (int i = 0, j = 2; i < n; i++, j += 6) {  
    	        String code = ascii.substring(j, j + 4);  
    	        char ch = (char) Integer.parseInt(code, 16);  
    	        sb.append(ch);  
    	    }  
    	    return sb.toString();  
    	}   
}