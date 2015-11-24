package main.src.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.StrUtils;
import main.src.common.TimeManager;
import main.src.service.UserService;
@Component("music")
@Entity
@Table(name = "music")
public class Music {
@Id @Column(name="music_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private String singer;
private String composer;
private String moto;
private String duration;
private String nation;
private Integer favor_cnt = 0;
private String create_date;
private String create_time;
private boolean del_flag = false;
@OneToMany(targetEntity=Comment.class,mappedBy="music")
@Cascade(CascadeType.ALL)
private List<Comment> comments = new LinkedList<Comment>();
public Music(){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSinger() {
	return singer;
}
public void setSinger(String singer) {
	this.singer = singer;
}
public String getComposer() {
	return composer;
}
public void setComposer(String composer) {
	this.composer = composer;
}
public String getMoto() {
	return moto;
}
public void setMoto(String moto) {
	this.moto = moto;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public String getNation() {
	return nation;
}
public void setNation(String nation) {
	this.nation = nation;
}
public Integer getFavor_cnt() {
	return favor_cnt;
}
public void setFavor_cnt(Integer favor_cnt) {
	this.favor_cnt = favor_cnt;
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
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}


}
