package main.src.entity;

public class Category {
int id;
String name;
int father;
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
public int getFather() {
	return father;
}
public void setFather(int father) {
	this.father = father;
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
