package main.src.entity.gallery.item;

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
import main.src.entity.gallery.City;
import main.src.entity.gallery.Corporation;
import main.src.entity.gallery.Dynasty;
import main.src.entity.gallery.Nation;
import main.src.entity.gallery.Religion;

@Component("figure")
@Entity
@Table(name = "figure")
public class Figure{
	@Id @Column(name="figure_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String domain;
	private String name;
	private String name_en;
	private String alias;
	private String cover;
	private char gender = 'f';
	private int height;
	private int age;
	@OneToOne(targetEntity = Dynasty.class)
	@JoinColumn(name="dynasty_id")
	private Dynasty dynasty;
	@OneToOne(targetEntity = Religion.class)
	@JoinColumn(name="religion_id")
	private Religion religion;
	private String echnic;
	@Temporal(TemporalType.DATE )
	@Column(name = "[from]")
	private Date from;
	@Temporal(TemporalType.DATE )
	private Date perish;
	@OneToOne(targetEntity = Nation.class)
	@JoinColumn(name="nation_id")
	private Nation nation;
	@OneToOne(targetEntity = City.class)
	@JoinColumn(name="city_id")
	private City city;
	private String job;
	private String position;
	@OneToOne(targetEntity = Corporation.class)
	@JoinColumn(name="corporation_id")
	private Corporation corp;
//	@OneToMany(targetEntity = Figure.class)
//	@JoinColumn(name="figure_id")
//	private Map<String,Figure> relationship = new HashMap<String,Figure>();
	private String profile;
	private boolean exhibit_flag = true;
	@Transient
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public Figure() {
	}
	public Figure(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public Religion getReligion() {
		return religion;
	}
	public void setReligion(Religion religion) {
		this.religion = religion;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		System.out.println("gender char");
		this.gender = gender;
	}
	public void setGender(String[] gender) {
		System.out.println("gender String[]");
		if(StringUtils.isNotEmpty(gender[0])){
			this.gender = gender[0].charAt(0);
		}
	}
	public void setGender(String gender) {
		System.out.println("gender String");
		if(StringUtils.isNotEmpty(gender)){
			this.gender = gender.charAt(0);
		}
	}
	public int getHeight() {
		return height;
	}
//	public void setHeight(int height) {
//		this.height = height;
//	}
	public void setHeight(String[] height) {
		if(StringUtils.isNotEmpty(height[0])){
			this.height = Integer.parseInt(height[0]);
		}
	}
	public Dynasty getDynasty() {
		return dynasty;
	}
	public void setDynasty(Dynasty dynasty) {
		this.dynasty = dynasty;
	}
	public String getEchnic() {
		return echnic;
	}
	public void setEchnic(String echnic) {
		this.echnic = echnic;
	}
	
	public Nation getNation() {
		return nation;
	}
	public void setNation(Nation nation) {
		this.nation = nation;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Corporation getCorp() {
		return corp;
	}
	public void setCorp(Corporation corp) {
		this.corp = corp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public boolean isExhibit_flag() {
		return exhibit_flag;
	}
	public void setExhibit_flag(boolean exhibit_flag) {
		this.exhibit_flag = exhibit_flag;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
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
