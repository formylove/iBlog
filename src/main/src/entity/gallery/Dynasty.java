package main.src.entity.gallery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import main.src.common.TimeManager;
import main.src.entity.gallery.item.Figure;

@Component("dynasty")
@Entity
@Table(name = "dynasty")
public class Dynasty{
	@Id @Column(name="dynasty_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean zhonghua;
	@Temporal(TemporalType.DATE )
	@Column(name = "[from]")
	private Date from;
	@Temporal(TemporalType.DATE )
	private Date perish;
	private String name;
	private String name_en;
	private Integer population;
	private Integer area;
	private Integer age;
	@OneToOne(targetEntity = City.class)
	@JoinColumn(name="capital_id")
	private City capital;
	@OneToOne(targetEntity = Figure.class)
	@JoinColumn(name="founder_id")
	private Figure founder;
	private String profile;
	@Transient
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public boolean isZhonghua() {
		return zhonghua;
	}
	public void setZhonghua(boolean zhonghua) {
		this.zhonghua = zhonghua;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public City getCapital() {
		return capital;
	}
	public void setCapital(City capital) {
		this.capital = capital;
	}
	public Figure getFounder() {
		return founder;
	}
	public void setFounder(Figure founder) {
		this.founder = founder;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getFrom() {
		return from != null?sdf.format(from):null;
	}
	public String getPerish() {
		return perish != null?sdf.format(perish):null;
	}
	public void setPerish(String perish) {
		if(StringUtils.isNotEmpty(perish)){
		try {
			this.perish = sdf.parse(perish);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(from != null){
			this.age =TimeManager. getAge(this.from,this.perish);
		} 
		}
	}
	public void setPerish(String[] perish) {
		if(StringUtils.isNotEmpty(perish[0])){
		try {
			this.perish = sdf.parse(perish[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(from != null){
			this.age = TimeManager. getAge(this.from,this.perish);
		}
		}
	}
	public void setFrom(String from) {
		if(StringUtils.isNotEmpty(from)){
		try {
			this.from = sdf.parse(from);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(perish != null){
			this.age = TimeManager. getAge(this.from,this.perish);
		}
		}
	}
	public void setFrom(String[] from) {
		if(StringUtils.isNotEmpty(from[0])){
		try {
			this.from = sdf.parse(from[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(perish != null){
			this.age =TimeManager. getAge(this.from,this.perish);
		}
		}
	}
	public Integer getAge() {
		if(age == 0 && this.from != null){
			this.age = TimeManager. getAge(this.from,new Date());
		}
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
