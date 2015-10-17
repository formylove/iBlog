package main.src.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.MailUtils;
import main.src.common.SqlUtils;
import main.src.entity.Record;
import main.src.entity.User;
import main.src.service.UserService;

public class LoginAction {
	User user;
	String email;
	String password;
	String psw_conf;
	String rule;
	String remember;
	String device;
	String browser;
	String os;
	String token;
	int id;
	//返回参数
	String portrait;
	String nick_name;
	String motto;
	String message;
	String self = "true";
	String isGood = "false";
	public String login(){
		message = UserService.loginDetect(email, password);
		if(message != null){
			return "done";
		}
		message = "登录成功！";
		user = UserService.login(email.toLowerCase(),remember);
		setPortrait(user.getPortrait());
		setNick_name(user.getNick_name());
		setMotto(user.getMotto());
		setId(user.getId());
		user = null;
		isGood = "true";
		return "done";
	}
	public String register() {
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		message = UserService.registerDetect(nick_name,email, password, psw_conf,rule);
		if(message != null){
			return "done";
		}
		message = "注册成功！";
		user = new User(nick_name, email.toLowerCase(), password,req);
		SqlUtils.executeInsert(user);
		MailUtils mailSender = new MailUtils();
		mailSender.sendActivateEmail(user.email.toLowerCase(), user.nick_name, user.token);
		setNick_name(user.getNick_name());
		setEmail(user.getEmail());
		user = null;
		isGood = "true";
		return "done";
	}
	public String activate() {
		user = UserService.getUserByToken(token);
		if(user == null || UserService.isExpired(token)){
			message = "激活链接已过期";
			return "expired";
		}else{
			if(!user.isEmail_val_flag()){//已经激活过
				user.setEmail_val_flag(true);
				//更新激活标志
				SqlUtils.executeUpdate("token='" + token + "'", user);
				//登录
				UserService.login(user, null);
				//跳转到主页
			}
			return "activated";
		}
	}
	public String logout() {
		UserService.logout();
		return null;
	}
	public String loadProfile() {
		user = UserService.getUser(id);
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		User loginedUser = UserService.getcurLoginUser(req);
		if(loginedUser == null || loginedUser.getId() != id){
			self = "false";
		}
		return "profile";
	}
	public String userSetting() {
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = UserService.getcurLoginUser(req);
		return "setting";
	}
	public String gainDeviceDetails(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域请求的问题，这个header就是让服务器支持CORS的
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Record record = new Record();
		record.setBrowser(browser.replace("undefined", ""));
		record.setDevice(device.replace("undefined", ""));
		record.setOs(os.replace("undefined", ""));
		session.setAttribute("hasDeviceDetail", "true");
		session.setAttribute("browser", record.getBrowser());
		session.setAttribute("device", record.getDevice());
		session.setAttribute("os", record.getOs());
		SqlUtils.executeUpdate("session_id='"+ session.getId() + "'", record);
		return null;
	}
	public String isLogined(){
		return "success";
	}
	
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getPsw_conf() {
		return psw_conf;
	}
	public void setPsw_conf(String psw_conf) {
		this.psw_conf = psw_conf;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIsGood() {
		return isGood;
	}
	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}





}
