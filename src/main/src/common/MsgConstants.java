package main.src.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class MsgConstants {
public static final String SUCCESS="success"; 
public static final String REDUPLICATIVE="reduplicative"; 
public static final String ESSAYPAGE="essaypage"; 
public static final String NOTEPAGE="notepage"; 
public static final String DELETED="deleted"; 
public static final String RECOVERED="recovered"; 
public static final String Essays="essays"; 
public static final String LIKE="like"; 
public static final String NO="N"; 
public static final String YES="Y"; 
public static final int ADMINID=1000; 
public static final int ROOTCAT=5000; 
public static final int MESBOOK=6666; 
public static Map<String, String> ISO31661ALPHA3 = new LinkedHashMap<String, String>(); 
public static Map<String, String> DYNASTY = new LinkedHashMap<String, String>(); 
public static Map<String, String> AUTHORITY = new LinkedHashMap<String, String>(); 
public static Map<String, String> SCORE = new LinkedHashMap<String, String>(); 
public static Map<String, String> RATE = new LinkedHashMap<String, String>(); 
static {
	ISO31661ALPHA3.put("nope", "国籍");
	ISO31661ALPHA3.put("CN", "中国");
	ISO31661ALPHA3.put("CN", "中国");
	ISO31661ALPHA3.put("US", "美国");
	ISO31661ALPHA3.put("JP", "日本");
	ISO31661ALPHA3.put("JP1", "韩国");
	ISO31661ALPHA3.put("JP2", "泰国");
	ISO31661ALPHA3.put("JP3", "法国");
	ISO31661ALPHA3.put("JP4", "英国");
	ISO31661ALPHA3.put("JP5", "德国");
	ISO31661ALPHA3.put("JP6", "俄罗斯");
	ISO31661ALPHA3.put("JP7", "西班牙");
	ISO31661ALPHA3.put("JP8", "意大利");
	ISO31661ALPHA3.put("JP9", "奥地利");
	ISO31661ALPHA3.put("JP00", "冰岛");
	ISO31661ALPHA3.put("JP88", "日本");
	
	
	DYNASTY.put("nope", "现代");
	DYNASTY.put("民国", "民国");
	DYNASTY.put("清朝", "清朝");
	DYNASTY.put("明朝", "明朝");
	DYNASTY.put("元朝", "元朝");
	DYNASTY.put("宋朝", "宋朝");
	DYNASTY.put("唐朝", "唐朝");
	DYNASTY.put("汉朝", "汉朝");
	DYNASTY.put("春秋", "春秋");
	DYNASTY.put("战国", "战国");
	
	AUTHORITY.put("10", "所有人可见");
	AUTHORITY.put("0", "自己可见");
	AUTHORITY.put("5", "登录可见");
	AUTHORITY.put("1", "珠海ip可见");
	AUTHORITY.put("2", "珠海ip不可见");
	
	RATE.put("nope", "评价");
	RATE.put("极好的", "极好的");
	RATE.put("必读", "必读");
	RATE.put("值得一读", "值得一读");
	RATE.put("可以一读", "可以一读");
	RATE.put("不值得读", "不值得读");
	RATE.put("烂", "烂");
	System.out.println("ios move on");
}
}