package main.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.essay.Essay;
import main.src.service.CommentService;
import main.src.service.UserService;
@Component("comment")
@Entity
@Table(name = "comment")
public class Comment {
	@Id	 @Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name="publisher_id" , nullable=false)
	private User publisher;
	@OneToOne(targetEntity = Comment.class)
	@JoinColumn(name="target_id")
	private Comment target;
	private String content;
	private int floor;
	private int unit;
	private String dev_name;
	@OneToOne(targetEntity=Note.class)
	@JoinColumn(name="note_id",referencedColumnName="note_id",nullable=true)
	private Note note;
	@OneToOne(targetEntity=Essay.class)
	@JoinColumn(name="essay_id",referencedColumnName="essay_id",nullable=true)
	private Essay essay;
	@OneToOne(targetEntity=Music.class)
	@JoinColumn(name="music_id",referencedColumnName="music_id",nullable=true)
	private Music music;
	@Column(updatable=false)
	private String create_date;
	@Column(updatable=false)
	private String create_time;
	private boolean del_flag = false;;
	public Comment(){
		setCreate_date(TimeManager.getDate());
		setCreate_time(TimeManager.getTime());
}
	public Comment(String target_id,int floor){
		setCreate_date(TimeManager.getDate());
		setCreate_time(TimeManager.getTime());
	}
	
public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
public Music getMusic() {
		return music;
	}
	public void setMusic(Music music) {
		this.music = music;
	}
public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
public Note getNote() {
		return note;
	}
	public Comment getTarget() {
	return target;
}
public void setTarget(Comment target) {
	this.target = target;
}
	public void setNote(Note note) {
		this.note = note;
	}
	public Essay getEssay() {
		return essay;
	}
	public void setEssay(Essay essay) {
		this.essay = essay;
	}
	public void setId(Integer id) {
		this.id = id;
	}
public int getId() {
	return id;
}

public String getDev_name() {
	return dev_name;
}
public void setDev_name(String dev_name) {
	this.dev_name = dev_name;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
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
