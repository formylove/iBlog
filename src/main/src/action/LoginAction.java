package main.src.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.MailUtils;
import main.src.common.SqlUtils;
import main.src.common.StrUtils;
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
	//���ز���
	String portrait;
	String nick_name;
	String motto;
	String message;
	String self = "true";
	String isGood = "false";
	//�޸��˻�
	String update_type;
	String qq;
	String autoplay;
	String newpassword;
	String job;
	char gender;
	Date birthday;
	
	public String login(){
		message = UserService.loginDetect(email, password);
		if(message != null){
			return "done";
		}
		message = "��¼�ɹ���";
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
		message = "ע��ɹ���";
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
			message = "���������ѹ���";
			return "expired";
		}else{
			if(!user.isEmail_val_flag()){//�Ѿ������
				user.setEmail_val_flag(true);
				//���¼����־
				SqlUtils.executeUpdate("token='" + token + "'", user);
				//��¼
				UserService.login(user, null);
				//��ת����ҳ
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
		response.setHeader("Access-Control-Allow-Origin", "*");//���������������⣬���header�����÷�����֧��CORS��
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
	public String update(){
		HttpServletRequest request=ServletActionContext.getRequest();
		user = UserService.getcurLoginUser(request);
		if(null == user){
			if(!StrUtils.valiName(nick_name)){
				message = "���ȵ�¼�˻�";
			}
		}else if("nick_name".equalsIgnoreCase(update_type)){
			if(!StrUtils.valiName(nick_name)){
				message = "�ǳƱ���ֻ����Ӣ�����������Լ��»���";
			}else {
				user.setNick_name(nick_name);
			}
		}else if("autoplay".equalsIgnoreCase(update_type)){
			if(StrUtils.notEmpty(autoplay)){
				user.setAutoplay(true);
			}else {
				user.setAutoplay(false);
			}
		}else if("motto".equalsIgnoreCase(update_type)){
				user.setMotto(motto);
		}else if("details".equalsIgnoreCase(update_type)){
			user.setBirthday(birthday);
			user.setGender(gender);
			user.setJob(job);
		}else if("password".equalsIgnoreCase(update_type)){
			if(!StrUtils.simpleChar(password) || StrUtils.isEmpty(password) || password.length()<8 || password.length()>16 || !password.equals(user.getPassword())){
				message = "ԭ�����������";
			}else if(!StrUtils.simpleChar(newpassword) || StrUtils.isEmpty(newpassword) || newpassword.length()<8 || newpassword.length()>16){
				message = "�����������8��16λ����ĸ���������";
				}else if(!user.getPassword().equals(psw_conf)){
				message = "�����������벻ͬ";
			}else{
				user.setPassword(newpassword);
			}
		}else if("binding".equalsIgnoreCase(update_type)){
			
		}
		if(StrUtils.isEmpty(message)){
			isGood = "true";
			SqlUtils.executeInsert(user);
		}
		return "done";
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
	public String getAutoplay() {
		return autoplay;
	}
	public void setAutoplay(String autoplay) {
		this.autoplay = autoplay;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
