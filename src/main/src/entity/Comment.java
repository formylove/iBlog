package main.src.entity;

public class Comment {
int id;
int user_id;
String profile;
String content;
int target;
int favour_cnt=33;
int append;
String create_date;
String create_time;
String ip;
String city;
boolean has_signature;
boolean is_visitor;
boolean del_flag;

public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public int getAppend() {
	return append;
}
public void setAppend(int append) {
	this.append = append;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getTarget() {
	return target;
}
public void setTarget(int target) {
	this.target = target;
}
public int getFavour_cnt() {
	return favour_cnt;
}
public void setFavour_cnt(int favour_cnt) {
	this.favour_cnt = favour_cnt;
}
public String getCreate_date() {
	return create_date;
}
public void setCreate_date(String create_date) {
	this.create_date = create_date;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public boolean isHas_signature() {
	return has_signature;
}
public void setHas_signature(boolean has_signature) {
	this.has_signature = has_signature;
}
public boolean isIs_visitor() {
	return is_visitor;
}
public void setIs_visitor(boolean is_visitor) {
	this.is_visitor = is_visitor;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}


}
