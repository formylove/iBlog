package main.src.entity;

public class Diary {
	
int id;
String title;
String author;
String profile;
String label;
int category;
String content;
boolean original_flag;
String original_link;
String email;
String create_date;
String create_time;
boolean del_flag;
int read_cnt;



public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public boolean isOriginal_flag() {
	return original_flag;
}
public void setOriginal_flag(boolean original_flag) {
	this.original_flag = original_flag;
}
public String getOriginal_link() {
	return original_link;
}
public void setOriginal_link(String original_link) {
	this.original_link = original_link;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}

public String getCreate_date() {
	return create_date;
}
public void setCreate_date(String create_date) {
	this.create_date = create_date;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}
public int getRead_cnt() {
	return read_cnt;
}
public void setRead_cnt(int read_cnt) {
	this.read_cnt = read_cnt;
}


}
