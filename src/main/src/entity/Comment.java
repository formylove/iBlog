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
@Table(name = "c")
public class Comment {
	@Id	 @Column(name="comment_id")
	private Integer id;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="publisher_id" , nullable=false)
	@Cascade(CascadeType.ALL)
	private User publisher;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="target_id")
	@Cascade(CascadeType.ALL)
	private User target;
	private String content;
	private String dev_name;
	private int favour_cnt = 0;
	@ManyToOne(targetEntity=Note.class)
	@JoinColumn(name="note_id",referencedColumnName="note_id",nullable=true)
	private Note note;
	@ManyToOne(targetEntity=Essay.class)
	@JoinColumn(name="essay_id",referencedColumnName="essay_id",nullable=true)
	private Essay essay;
	@ManyToOne(targetEntity=Music.class)
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
		setId(CommentService.getCurId(target_id, floor));
		User user = UserService.getcurLoginUser(null);
		setPublisher(user);
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
	public User getTarget() {
		return target;
	}
	public void setTarget(User target) {
		this.target = target;
	}
public Note getNote() {
		return note;
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
public int getFavour_cnt() {
	return favour_cnt;
}
public void setFavour_cnt(int favour_cnt) {
	this.favour_cnt = favour_cnt;
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
