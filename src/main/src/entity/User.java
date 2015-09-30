package main.src.entity;


public class User {
	
int id;
String user_name;
String nick_name;
String login_name;
String password;
String portrait;
String motto;
String email;
String QQ;
String phone;
String last_login_ip;
String last_login_date;
String last_login_time;
char gender;
boolean del_flag;
int authority;
int login_Cnt;



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
public String getQQ() {
	return QQ;
}
public void setQQ(String qQ) {
	QQ = qQ;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getLast_login_ip() {
	return last_login_ip;
}
public void setLast_login_ip(String last_login_ip) {
	this.last_login_ip = last_login_ip;
}
public String getLast_login_date() {
	return last_login_date;
}
public void setLast_login_date(String last_login_date) {
	this.last_login_date = last_login_date;
}
public String getLast_login_time() {
	return last_login_time;
}
public void setLast_login_time(String last_login_time) {
	this.last_login_time = last_login_time;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
public int getLogin_Cnt() {
	return login_Cnt;
}
public void setLogin_Cnt(int login_Cnt) {
	this.login_Cnt = login_Cnt;
}



}
