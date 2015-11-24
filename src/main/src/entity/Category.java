package main.src.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("category")
@Entity
@Table(name = "cat")
public class Category {
	@Id @Column(name="category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String desc;
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="moto_Category",
	joinColumns=@JoinColumn(name="category_id", nullable=false))
	@MapKeyColumn(name="moto_token")
	@MapKeyClass(String.class)
	@Column(name="moto")
	private Map<String,String> motos = new HashMap<String,String>();
	private boolean del_flag = false;

public int getId() {
	return id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}
public void setId(Integer id) {
	this.id = id;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public Map<String, String> getMotos() {
	return motos;
}
public void setMotos(Map<String, String> motos) {
	this.motos = motos;
}
}
