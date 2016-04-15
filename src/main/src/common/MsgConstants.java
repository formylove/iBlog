package main.src.common;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class MsgConstants {
public static final String SUCCESS="success"; 
public static final String DONE="done"; 
public static final String OK="OK"; 
public static final String EDIT="edit"; 
public static final String DISPLAY="display"; 
public static final String HOMEPAGE="homepage"; 
public static final String LIST="list"; 
public static final String DATAGRID="datagrid"; 
public static final String RETRIEVE="retrieve"; 
public static final String NO="N"; 
public static final String YES="Y"; 
public static Properties ISO31661ALPHA3 = new Properties(); 
public static Properties DYNASTY = new Properties(); 
public static Properties AUTHORITY = new Properties(); 
public static Properties SCORE = new Properties(); 
public static Properties RATE = new Properties();
public static Properties GENDER = new Properties();
public static Map<Integer,String> CU = new LinkedHashMap<Integer,String>();
public MsgConstants() {
	AUTHORITY.put("10", "所有人可见");
	AUTHORITY.put("0", "自己可见");
	AUTHORITY.put("5", "登录可见");
	AUTHORITY.put("1", "珠海ip可见");
	AUTHORITY.put("2", "珠海ip不可见");
	System.out.println("pppppppppppppppppp");
	GENDER.put('f', "女");
	GENDER.put('m', "男");
	
	CU.put(100000000, "亿");
	CU.put(1000000, "百万");
	CU.put(10000, "万");
	CU.put(1000, "千");
	CU.put(100, "百");
	CU.put(10, "十");
	CU.put(1, "一");
	
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
	
	RATE.put("nope", "评价");
	RATE.put("再读一遍！", "再读一遍！");
	RATE.put("必读", "必读");
	RATE.put("值得一读", "值得一读");
	RATE.put("可以一读", "可以一读");
	RATE.put("不值得读", "不值得读");
	RATE.put("烂", "烂");
	
	ISO31661ALPHA3.put("中国", "中国");
	ISO31661ALPHA3.put("美国", "美国");
	ISO31661ALPHA3.put("日本", "日本");
	ISO31661ALPHA3.put("韩国", "韩国");
	ISO31661ALPHA3.put("泰国", "泰国");
	ISO31661ALPHA3.put("法国", "法国");
	ISO31661ALPHA3.put("英国", "英国");
	ISO31661ALPHA3.put("德国", "德国");
	ISO31661ALPHA3.put("俄罗斯", "俄罗斯");
	ISO31661ALPHA3.put("西班牙", "西班牙");
	ISO31661ALPHA3.put("意大利", "意大利");
	ISO31661ALPHA3.put("奥地利", "奥地利");
	ISO31661ALPHA3.put("冰岛", "冰岛");
}

//整个app生命周期只执行一次
static {
	AUTHORITY.put("10", "所有人可见");
	AUTHORITY.put("0", "自己可见");
	AUTHORITY.put("5", "登录可见");
	AUTHORITY.put("1", "珠海ip可见");
	AUTHORITY.put("2", "珠海ip不可见");
	
	GENDER.put('f', "女");
	GENDER.put('m', "男");
	
	CU.put(100000000, "亿");
	CU.put(1000000, "百万");
	CU.put(10000, "万");
	CU.put(1000, "千");
	CU.put(100, "百");
	CU.put(10, "十");
	CU.put(1, "一");
	
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
	
	RATE.put("nope", "评价");
	RATE.put("再读一遍！", "再读一遍！");
	RATE.put("必读", "必读");
	RATE.put("值得一读", "值得一读");
	RATE.put("可以一读", "可以一读");
	RATE.put("不值得读", "不值得读");
	RATE.put("烂", "烂");
	
	ISO31661ALPHA3.put("中国", "中国");
	ISO31661ALPHA3.put("美国", "美国");
	ISO31661ALPHA3.put("日本", "日本");
	ISO31661ALPHA3.put("韩国", "韩国");
	ISO31661ALPHA3.put("泰国", "泰国");
	ISO31661ALPHA3.put("法国", "法国");
	ISO31661ALPHA3.put("英国", "英国");
	ISO31661ALPHA3.put("德国", "德国");
	ISO31661ALPHA3.put("俄罗斯", "俄罗斯");
	ISO31661ALPHA3.put("西班牙", "西班牙");
	ISO31661ALPHA3.put("意大利", "意大利");
	ISO31661ALPHA3.put("奥地利", "奥地利");
	ISO31661ALPHA3.put("冰岛", "冰岛");
	Log.print("msgConstant", "init");
}
	public static void init() {}
}