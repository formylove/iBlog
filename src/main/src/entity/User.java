package main.src.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import main.src.common.IPParser;
import main.src.common.TimeManager;

public class User {

public int id;
public String user_name;
public String nick_name;
public String login_name;
public String password;
public String md5;
public char gender;
public String portrait;
public String motto;
public String email;
public String qq;
public String phone;
public String device;
public String city;
public String register_ip;
public Timestamp register_date;
public String token;
public int authority;
public boolean email_val_flag;
public boolean del_flag;
public User(String nick_name,String email,String password,String ip,String city,String device){
	setNick_name(nick_name);
	setEmail(email);
	setPassword(password);
	setCity(city);
	setDevice(device);
	setToken(UUID.randomUUID().toString());
//	Date date = new Date();       
//	setRegister_date(new Timestamp(date.getTime()));
}
public User(){
}


public String getDevice() {
	return device;
}
public void setDevice(String device) {
	this.device = device;
}
public String getMd5() {
	return md5;
}
public void setMd5(String md5) {
	this.md5 = md5;
}
public boolean isEmail_val_flag() {
	return email_val_flag;
}
public Timestamp getRegister_date() {
	return register_date;
}
public void setRegister_date(Timestamp register_date) {
	this.register_date = register_date;
}
public void setEmail_val_flag(boolean email_val_flag) {
	this.email_val_flag = email_val_flag;
}
public String getMotto() {
	return motto;
}
public void setMotto(String motto) {
	this.motto = motto;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getNick_name() {
	return nick_name;
}
public void setNick_name(String nick_name) {
	this.nick_name = nick_name;
}
public String getLogin_name() {
	return login_name;
}
public void setLogin_name(String login_name) {
	this.login_name = login_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getQq() {
	return qq;
}


public void setQq(String qq) {
	this.qq = qq;
}


public String getPhone() {
	return phone;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getRegister_ip() {
	return register_ip;
}


public void setRegister_ip(String register_ip) {
	this.register_ip = register_ip;
}


public String getToken() {
	return token;
}


public void setToken(String token) {
	this.token = token;
}


public char getGender() {
	return gender;
}


public void setGender(char gender) {
	this.gender = gender;
}


public int getAuthority() {
	return authority;
}


public void setAuthority(int authority) {
	this.authority = authority;
}


public boolean isDel_flag() {
	return del_flag;
}


public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}

}
