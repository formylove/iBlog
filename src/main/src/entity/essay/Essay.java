package main.src.entity.essay;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
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
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import main.src.common.ImageUtils;
import main.src.common.StrUtils;
import main.src.common.TimeManager;
import main.src.entity.Category;
import main.src.entity.Comment;
import main.src.entity.Music;
import main.src.service.CategoryService;
@Component("essay")
@Entity
@Table(name = "essay")
public class Essay {
@Id @Column(name="essay_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;
private String cover;
private String subtitle;
private String author;
private String author_link;
private String author_desc;
private String label;
@OneToMany(targetEntity=Comment.class,mappedBy="essay",fetch=FetchType.EAGER)
private List<Comment> comments = new LinkedList<Comment>();
@OneToOne(targetEntity = Category.class)
@JoinColumn(name="category_id" , referencedColumnName="category_id",nullable=false)
private Category category;
@Type(type="text") 
private String content;
private Integer read_cnt = 0;
private Integer favor_cnt = 0;
private boolean original_flag = true;
private String original_link;
@OneToOne(targetEntity = Music.class)
@JoinColumn(name="music_id")
private Music music;
private String create_date;
private String portrait;
private String create_time;
private int authority = 10;
public boolean del_flag = false;;
@Resource(name = "categoryService")
@Transient
private CategoryService categoryService;
@Transient
private final String splitTag =",";
public Essay(){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
}
public Essay(boolean original_flag){
	setCreate_date(TimeManager.getDate());
	setCreate_time(TimeManager.getTime());
	setOriginal_flag(original_flag);
	
	
	setWebmasterDetail();
}
public String[] getLabels(){
	if(!StrUtils.isEmpty(label)){
		return label.split(splitTag);
	}else{
		return null;
	}
}
public void setWebmasterDetail() {
//	if(original_flag){
//		User user = userService.get(2);
//		author = user.getNick_name();
//		author_desc = user.getMotto();
//		author_link = "user/2";
//		}
}

public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
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
public String getBcover() {
	return ImageUtils.generateIsoName(cover, ImageUtils.BIG);
}
public Music getMusic() {
	return music;
}
public void setMusic(Music music) {
	this.music = music;
}
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
public int getFavor_cnt() {
	return favor_cnt;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	if(StrUtils.notEmpty(label)){
		this.label = label.replaceAll(" ","").replaceAll(splitTag+"+$", "");
	}else{
		this.label = label;
	}
}
public String getContent() {
	return content;
}
public Category getCategory() {
	return category;
}

public CategoryService getCategoryService() {
	return categoryService;
}
public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}
public void setCategory(Category category) {
	this.category = category;
}
//public void setCategory(String category_id) {
//	this.category = categoryService.get(Integer.parseInt(category_id));
//}
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

public String getCover() {
	return cover;
}
public void setCover(String cover) {
	cover = StringUtils.stripToNull(cover);
	if(StringUtils.isNotEmpty(cover)){
		this.cover = ImageUtils.saveImageFromUrlToDepot(cover);
	}
	this.cover = cover;
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
public void setRead_cnt(Integer read_cnt) {
	System.out.println("read_cnt Integer");
	this.read_cnt = read_cnt;
}
public void setRead_cnt(int read_cnt) {
	System.out.println("read_cnt int");
	this.read_cnt = read_cnt;
}
public void setRead_cnt(String[] read_cnt) {
	System.out.println("read_cnt String[]");
	this.read_cnt = Integer.parseInt(read_cnt[0]);
}
public void setFavor_cnt(Integer favor_cnt) {
	System.out.println("favor_cnt Integer");
	this.favor_cnt = favor_cnt;
}
public void setFavor_cnt(int favor_cnt) {
	System.out.println("favor_cnt Integer");
	this.favor_cnt = favor_cnt;
}
public void setFavor_cnt(String[] favor_cnt) {
	System.out.println("favor_cnt String[]");
	this.favor_cnt = Integer.parseInt(favor_cnt[0]);
}
}
