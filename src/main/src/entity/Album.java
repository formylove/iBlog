package main.src.entity;

public class Album {
int id;
String name;
String label;
String desc;
String cover;
String last_visitor;
String city_from;
String create_date;
String create_time;
int authority;
int level;
boolean del_flag;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public String getLast_visitor() {
	return last_visitor;
}
public void setLast_visitor(String last_visitor) {
	this.last_visitor = last_visitor;
}
public String getCity_from() {
	return city_from;
}
public void setCity_from(String city_from) {
	this.city_from = city_from;
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
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}

}
