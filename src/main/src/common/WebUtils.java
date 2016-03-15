package main.src.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;


public class WebUtils {
static public String getCookie(String name,HttpServletRequest request){
	if(request == null){
		ActionContext act = ActionContext.getContext();
		request = (HttpServletRequest)act.get(StrutsStatics.HTTP_REQUEST);
		
	}
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
	for(Cookie cookie:cookies){
		if(name.equalsIgnoreCase(cookie.getName())){
			return cookie.getValue();
		}
	}
	}
	return null;
}
static public String getMailLoginUrl(String email){
	String domain = email.substring(email.indexOf("@")+1,email.indexOf("."));
	String url = null;
	if(domain.equalsIgnoreCase("163")){
		url = "http://mail.163.com/";
	}else if(domain.equalsIgnoreCase("qq")){
		url = "https://mail.qq.com/cgi-bin/loginpage";
	}else  if(domain.equalsIgnoreCase("gmail")){
		url = "http://www.yomail.com";
	}else  if(domain.equalsIgnoreCase("sina")){
		url = "https://mail.sina.com.cn/";
	}else{
		url = "http://www.baidu.com/s?cl=3&wd=" + domain + " 邮箱" ;
	}
	return url;
}
private final static String[] conditions={"广东","珠海","ipx","mac"};
static public boolean neededRecord(HttpServletRequest request){
	IPParser i = new IPParser(request);
	String ip = request.getRemoteAddr();
	// TODO remove this
	if(ip.equals("127.0.0.1") || ip.equals("192.168.1.110")){
		ip = "122.95.231.214";
	}
    String addr = i.getCountry().trim();
    for(String condition:conditions){
    	if(StringUtils.contains(addr, condition) ||StringUtils.contains(ip, condition))
    	{
    		return true;
    	}
    }
    return false;
}
static public String getMACAddress(String ip) throws Exception {    
    String line = "";    
    String macAddress = "";    
    final String MAC_ADDRESS_PREFIX = "MAC Address = ";    
    final String LOOPBACK_ADDRESS = "127.0.0.1";    
    //如果为127.0.0.1,则获取本地MAC地址。    
    if (LOOPBACK_ADDRESS.equals(ip)) {    
        InetAddress inetAddress = InetAddress.getLocalHost();    
        //貌似此方法需要JDK1.6。    
        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();    
        //下面代码是把mac地址拼装成String    
        StringBuilder sb = new StringBuilder();    
        for (int i = 0; i < mac.length; i++) {    
            if (i != 0) {    
                sb.append("-");    
            }    
            //mac[i] & 0xFF 是为了把byte转化为正整数    
            String s = Integer.toHexString(mac[i] & 0xFF);    
            sb.append(s.length() == 1 ? 0 + s : s);    
        }    
        //把字符串所有小写字母改为大写成为正规的mac地址并返回    
        macAddress = sb.toString().trim().toUpperCase();    
        return macAddress;    
    }    
    //获取非本地IP的MAC地址    
        Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);    
        InputStreamReader isr = new InputStreamReader(p.getInputStream());    
        BufferedReader br = new BufferedReader(isr);    
        while ((line = br.readLine()) != null) {    
            if (line != null) {    
                int index = line.indexOf(MAC_ADDRESS_PREFIX);    
                if (index != -1) {    
                    macAddress = line.substring(index + MAC_ADDRESS_PREFIX.length()).trim().toUpperCase();    
                }    
            }    
        }    
        br.close();    
    return macAddress;    
}  
}
