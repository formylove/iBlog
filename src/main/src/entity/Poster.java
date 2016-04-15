package main.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component("poster")
@Entity
@Table(name = "poster")
public class Poster {
@Id	 @Column(name="poster_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(name = "[desc]")
private String desc;
private String url;
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "[order]")
private String order;
private String cover;
public Integer getId() {
	return id;
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getOrder() {
	return order;
}
public void setOrder(String order) {
	this.order = order;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
}
