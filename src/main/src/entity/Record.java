package main.src.entity;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.src.common.MessageUtils;
import main.src.common.Spider;
import main.src.common.StringUtils;
import main.src.common.WebUtils;
import net.sf.json.JSONObject;

public class Record {
	public int id;
	public String email;
	public String qq;
	public String ip;
	public String mac;
	public String os;
	public String browser;
	public String device;
	public String province;
	public String city;
	public String district;
	public String provider;
	public String user_agent;
	public String module;
	public String content;
	public String url;
	public String session_id;
	public Timestamp time;
	public Record(){
		
	}
	public Record(HttpServletRequest request){
		HttpSession session = request.getSession(true);//还没有创建则创建一个session
		//设置meta信息
		setIp(request.getRemoteAddr());
		setUrl(request.getRequestURI());
		setUser_agent(request.getHeader("user-agent"));
		setSession_id(session.getId());
		//设置位置信息
		setProvider((String)session.getAttribute("provider"));
		setProvince((String)session.getAttribute("province"));
		setCity((String)session.getAttribute("city"));
		setDistrict((String)session.getAttribute("district"));
		//设置设备信息
		setBrowser((String)session.getAttribute("browser"));
		setDevice((String)session.getAttribute("device"));
		setOs((String)session.getAttribute("os"));
		//提取位置信息
		if(StringUtils.isEmpty(province) && StringUtils.isEmpty(city) && StringUtils.isEmpty(district) && StringUtils.isEmpty(provider)){
			//ToDo replace Ip here
			String location = Spider.SendGet(MessageUtils.getMessageFromUrl("api.location") + "122.95.231.214");
			if(StringUtils.notEmpty(location)){
				JSONObject js = JSONObject.fromObject(location);
				if(js != null){
					JSONObject data = js.getJSONObject("data");
					if(data != null){
						setProvince(data.getString("province"));
						setCity(data.getString("city"));
						setDistrict(data.getString("district"));
						setProvider(data.getString("linetype"));
					}
				}
			}
			session.setAttribute("province", getProvince());
			session.setAttribute("city", getCity());
			session.setAttribute("district", getDistrict());
			session.setAttribute("provider", getProvider());
		}
		try {
			setMac(WebUtils.getMACAddress(ip));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getUser_agent() {
		return user_agent;
	}
	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

}
