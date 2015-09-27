package main.src.entity;

public class Comment {
public int id;
public int user_id;
public String user_name;
public String portrait;
public String signature;    
public String content;
public int replyer;
public String replyer_name;
public String dev_name;
public int favour_cnt;
public boolean is_visitor;
public String create_date;
public String create_time;
public boolean del_flag;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getDev_name() {
	return dev_name;
}
public void setDev_name(String dev_name) {
	this.dev_name = dev_name;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}
public String getSignature() {
	return signature;
}
public void setSignature(String signature) {
	this.signature = signature;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

public int getReplyer() {
	return replyer;
}
public void setReplyer(int replyer) {
	this.replyer = replyer;
}
public String getReplyer_name() {
	return replyer_name;
}
public void setReplyer_name(String replyer_name) {
	this.replyer_name = replyer_name;
}
public int getFavour_cnt() {
	return favour_cnt;
}
public void setFavour_cnt(int favour_cnt) {
	this.favour_cnt = favour_cnt;
}
public boolean isIs_visitor() {
	return is_visitor;
}
public void setIs_visitor(boolean is_visitor) {
	this.is_visitor = is_visitor;
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
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}

}
