package main.src.entity;

import java.util.List;

import main.src.common.SqlUtils;

public class Genre {
int id;
String name;
String type;
boolean del_flag;

public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllGenre(boolean withDel){
	String sql = "select * from genre where " + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllBookGenre(boolean withDel){
	String sql = "select * from genre where type='book' and" + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllMovieGenre(boolean withDel){
	String sql = "select * from genre where type='movie' and" + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
}
