package main.src.entity;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.TimeManager;
import main.src.entity.gallery.Nation;
import main.src.entity.gallery.item.Figure;
import main.src.service.MusicService;
@Component("music")
@Entity
@Table(name = "music")
public class Music {
@Id @Column(name="music_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private Integer precedence = 0;
private String name;
@OneToOne(targetEntity = Figure.class)
@JoinColumn(name="singer_id")
private Figure singer;
private String composer;
private String cover;
private String url;
private String style;
private String motto;
@OneToOne(targetEntity = Nation.class)
@JoinColumn(name="nation_id")
private Nation nation;
private Integer favor_cnt = 0;
private String create_date;
private String create_time;
private boolean del_flag = false;
@OneToMany(targetEntity=Comment.class,mappedBy="music")
private List<Comment> comments = new LinkedList<Comment>();
@Transient
@Resource(name="musicService")
private MusicService musicService;
public Music(){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
}
public Integer getId() {
	return id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public Integer getPrecedence() {
	return precedence;
}
public void setPrecedence(Integer precedence) {
	musicService.clear(precedence);
	this.precedence = precedence;
}
public void setName(String name) {
		name = StringUtils.trimToNull(name);
	this.name = name;
}
public String getComposer() {
	return composer;
}
public void setComposer(String composer) {
	this.composer = composer;
}
public Figure getSinger() {
	return singer;
}
public void setSinger(Figure singer) {
	this.singer = singer;
}
public String getMotto() {
	return motto;
}
public void setMotto(String motto) {
	this.motto = motto;
}
public String getStyle() {
	return style;
}
public void setStyle(String style) {
	this.style = style;
}
public Nation getNation() {
	return nation;
}
public void setNation(Nation nation) {
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
public MusicService getMusicService() {
	return musicService;
}
public void setMusicService(MusicService musicService) {
	this.musicService = musicService;
}


}
