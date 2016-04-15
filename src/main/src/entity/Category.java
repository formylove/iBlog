package main.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import main.src.common.ImageUtils;

@Component("category")
@Entity
@Table(name = "category")
public class Category {
	@Id @Column(name="category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name = "[desc]")
	private String desc;
	private String profile;
	private String cover;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "[order]")
	private int order;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCover() {
		return cover;
	}
	public String getTcover() {
		return ImageUtils.generateIsoName(cover,ImageUtils.THUMBNAIL);
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	

}
