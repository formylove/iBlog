package main.src.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import main.src.common.TimeManager;
@Component("note")
@Entity
@Table(name = "note")
public class Note {
@Id @Column(name="note_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;
private String subtitle;
private String author;
private String author_link;
private String author_desc;
private String content;
private int read_cnt=0;
private int favor_cnt=0;
private boolean original_flag = true;
private String original_link;
@OneToOne(targetEntity = Music.class)
@JoinColumn(name="music_id")
private Music music;
@OneToOne(targetEntity = Opus.class)
@JoinColumn(name="opus_id" , referencedColumnName="opus_id",nullable=false)
private Opus opus;
@OneToMany(targetEntity=Comment.class,mappedBy="note" ,fetch=FetchType.EAGER)
private List<Comment> comments = new LinkedList<Comment>();
private String create_date;
private String create_time;
private int authority;
private boolean del_flag = false;
public Note(){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
}

public Note(String subtitle, String author) {
	this.subtitle = subtitle;
	this.author = author;
}

public Note(boolean original_flag){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
	setOriginal_flag(original_flag);
	
	
	setWebmasterDetail();
}
public void setWebmasterDetail() {
//	if(original_flag){
//		User user = UserService.getUser(2);
//		author = user.getNick_name();
//		author_desc = user.getMotto();
//		author_link = "user/2";
//		}
}



public List<Comment> getComments() {
	return comments;
}

public void setComments(List<Comment> comments) {
	this.comments = comments;
}

public Opus getOpus() {
	return opus;
}

public void setOpus(Opus opus) {
	this.opus = opus;
}

public void setId(Integer id) {
	this.id = id;
}

public String getSubtitle() {
	return subtitle;
}
public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}
public String getAuthor_link() {
	return author_link;
}
public void setAuthor_link(String author_link) {
	this.author_link = author_link;
}
public String getAuthor_desc() {
	return author_desc;
}
public void setAuthor_desc(String author_desc) {
	this.author_desc = author_desc;
}
public int getAuthority() {
	return authority;
}
public Music getMusic() {
	return music;
}

public void setMusic(Music music) {
	this.music = music;
}

public void setAuthority(int authority) {
	this.authority = authority;
}
public int getFavor_cnt() {
	return favor_cnt;
}
public void setFavor_cnt(int favor_cnt) {
	this.favor_cnt = favor_cnt;
}
public int getId() {
	return id;
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
public void setFavor_cnt(Integer favor_cnt) {
	this.favor_cnt = favor_cnt;
}


}
