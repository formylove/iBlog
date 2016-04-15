package main.src.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.ImageUtils;
import main.src.common.MailUtils;
import main.src.common.MsgConstants;
import main.src.common.SqlUtils;
import main.src.common.StrUtils;
import main.src.entity.Record;
import main.src.entity.User;
import main.src.service.RecordService;
import main.src.service.UserService;

public class LoginAction {
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "recordService")
	private RecordService recordService;
	private User user;
	private String email;
	private String password;
	private String newpassword;
	private String psw_conf;
	private String rule;
	private String remember;
	private String device;
	private String browser;
	private String os;
	private String token;
	private int id;
	//返回参数
	private String nick_name;
	private String motto;
	private String message;
	private String self = "true";
	private boolean isGood = false;
	//修改账户
	private String update_type;
	private String qq;
	private int level;
	private boolean autoplay;
	private String phone;
	private String wechat;
	private char gender;
	private Date birthday;
	private float w;
	private float h;
	private float x;
	private float y;
	private String portrait;
	public String login(){
		message = userService.loginDetect(email, password);
		if(message != null){
			return "done";
		}
		message = "登录成功！";
		user = userService.login(email.toLowerCase(),remember);
		setPortrait(user.getPortrait());
		setNick_name(user.getNick_name());
		setMotto(user.getMotto());
		setId(user.getId());
		setLevel(user.getAuthority());
		isGood = true;
		return "done";
	}
	public String register() {
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		message = userService.registerDetect(nick_name,email, password, psw_conf,rule);
		if(message != null){
			return "done";
		}
		message = "注册成功！";
		user = new User(nick_name, email.toLowerCase(), password,req);
		userService.save(user);
		MailUtils mailSender = new MailUtils();
		mailSender.sendActivateEmail(user.getEmail().toLowerCase(), user.getNick_name(), user.getToken());
		setNick_name(user.getNick_name());
		setEmail(user.getEmail());
		user = null;
		isGood = true;
		return MsgConstants.DONE;
	}
	public String activate() {
		user = userService.getUserByToken(token);
		if(user == null || userService.isExpired(token)){
			message = "激活链接已过期";
			return "expired";
		}else{
			if(!user.isEmail_val_flag()){//已经激活过
				user.setEmail_val_flag(true);
				//更新激活标志
				userService.activate(token);
				//登录
				userService.login(user, null);
				//跳转到主页
			}
			return "activated";
		}
	}
	public String logout() {
		userService.logout();
		return null;
	}
	public String load() {
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		User loginedUser = userService.getcurLoginUser(req);
		user = userService.get(id);
		if(loginedUser == null || (loginedUser.getId() != id && loginedUser.getAuthority() != 0)){
			return "people";
		}else{
			return "profile";
		}
	}
	public String userSetting() {
		HttpServletRequest req = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userService.getcurLoginUser(req);
		return "setting";
	}
	public String gainDeviceDetails(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");//解决跨域请求的问题，这个header就是让服务器支持CORS的
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Record record = recordService.getRecordByToken(session.getId());
		record.setBrowser(browser.replace("undefined", ""));
		record.setDevice(device.replace("undefined", ""));
		record.setOs(os.replace("undefined", ""));
		recordService.update(record);
		session.setAttribute("hasDeviceDetail", "true");
		session.setAttribute("browser", record.getBrowser());
		session.setAttribute("device", record.getDevice());
		session.setAttribute("os", record.getOs());
		return null;
	}
	public String update(){
		HttpServletRequest request=ServletActionContext.getRequest();
		User loginedUser = userService.getcurLoginUser(request);
		user = userService.get(id);
		if(null == loginedUser || (loginedUser.getId() != id && loginedUser.getAuthority() !=0)){
				message = "请先登录账户";
		}else if("nick_name".equalsIgnoreCase(update_type)){
				message = userService.valiName(nick_name);
				user.setNick_name(nick_name);
		}else if("autoplay".equalsIgnoreCase(update_type)){
				user.setAutoplay(autoplay);
		}else if("motto".equalsIgnoreCase(update_type)){
				user.setMotto(motto);
		}else if("details".equalsIgnoreCase(update_type)){
			if(!StrUtils.valiPhone(phone)){
				message = "请输入正确手机号";
			}else if(!StringUtils.isNumeric(qq) || StringUtils.length(qq)>11 || StringUtils.length(qq)<5){
				message = "请输入正确QQ号";
			}else if(!StrUtils.simpleChar(wechat)){
				message = "请输入正确微信号";
				
			}else{
				user.setGender(gender);
				user.setQq(qq);
				user.setWechat(wechat);
				user.setPhone(phone);
				if(loginedUser.getAuthority() == 0){
					user.setAuthority(level);
				}
				user.setBirthday(birthday);
			}
		}else if("password".equalsIgnoreCase(update_type)){
			if(!StrUtils.simpleChar(password) || StrUtils.isEmpty(password) || password.length()<8 || password.length()>16 || !password.equals(user.getPassword())){
				message = "原密码输入错误";
			}else if(!StrUtils.simpleChar(newpassword) || StrUtils.isEmpty(newpassword) || newpassword.length()<8 || newpassword.length()>16){
				message = "新密码必须由8到16位的字母和数字组成";
				}else if(!newpassword.equals(psw_conf)){
				message = "两次输入密码不同";
			}else{
				user.setPassword(newpassword);
			}
		}else if("portrait".equalsIgnoreCase(update_type)){
			if(!portrait.equals(user.getPortrait())){
	    		ImageUtils.deleteImg(user.getPortrait());
	    		portrait = ImageUtils.cut(portrait, w, h, x, y,ImageUtils.PORTRAIT);
	    		user.setPortrait(portrait);
	    	}
		}else if("binding".equalsIgnoreCase(update_type)){
			
		}
		if(StrUtils.isEmpty(message)){
			isGood = true;
			userService.update(user);
		}
		return MsgConstants.DONE;
	}
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getUpdate_type() {
		return update_type;
	}
	public void setUpdate_type(String update_type) {
		this.update_type = update_type;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public boolean isAutoplay() {
		return autoplay;
	}
	public void setAutoplay(boolean autoplay) {
		this.autoplay = autoplay;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
 	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String isLogined(){
		return "success";
	}
	
	public String getSelf() {
		return self;
	}
	public float getW() {
		return w;
	}
	public void setW(float w) {
		this.w = w;
	}
	public float getH() {
		return h;
	}
	public void setH(float h) {
		this.h = h;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
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
	
	@JSON(serialize=false)
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
	@JSON(serialize=false)
	public String getPsw_conf() {
		return psw_conf;
	}
	public void setPsw_conf(String psw_conf) {
		this.psw_conf = psw_conf;
	}
	@JSON(serialize=false)
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
	@JSON(serialize=false)
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
	public boolean getIsGood() {
		return isGood;
	}
	public void setGood(boolean isGood) {
		this.isGood = isGood;
	}
	@JSON(serialize=false)
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@JSON(serialize=false)
	public RecordService getRecordService() {
		return recordService;
	}
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}





}
