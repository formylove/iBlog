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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import main.src.common.TimeManager;
import main.src.entity.gallery.item.Figure;

@Component("corporation")
@Entity
@Table(name = "corporation")
public class Corporation {
@Id	 @Column(name="corporation_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String industry;
private String name;
private String name_en;
private String cover;
@Temporal(TemporalType.DATE )
@Column(name = "[from]")
private Date from;
@OneToOne(targetEntity = City.class)
@JoinColumn(name="headquarters_id")
private City headquarters;
@OneToOne(targetEntity = Nation.class)
@JoinColumn(name="nation_id")
private Nation nation;
@OneToOne(targetEntity = Figure.class)
@JoinColumn(name="founder_id")
private Figure founder = new Figure();
@OneToOne(targetEntity = Figure.class)
@JoinColumn(name="chairman_id")
private Figure chairman;
@OneToOne(targetEntity = Figure.class)
@JoinColumn(name="ceo_id")
private Figure CEO;
private Integer turnover;
private Integer marketCapitalization;
private Integer headcount;
private String brands;
private String profile;
@Transient
SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//@ManyToOne(targetEntity = Corporation.class)
//@JoinColumn(name="parent_corporation_id",referencedColumnName="corporation_id")
//private Corporation parent;
//@OneToMany(targetEntity = Corporation.class ,mappedBy= "parent")
//private List<Corporation> children = new ArrayList<Corporation>();
public Corporation() {
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getIndustry() {
	return industry;
}
public void setIndustry(String industry) {
	this.industry = industry;
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
public void setFrom(Date from) {
	this.from = from;
}
public City getHeadquarters() {
	return headquarters;
}
public void setHeadquarters(City headquarters) {
	this.headquarters = headquarters;
}
public Figure getChairman() {
	return chairman;
}
public void setChairman(Figure chairman) {
	this.chairman = chairman;
}
public Figure getCEO() {
	return CEO;
}
public void setCEO(Figure cEO) {
	CEO = cEO;
}
public Integer getTurnover() {
	return turnover;
}
public void setTurnover(Integer turnover) {
	this.turnover = turnover;
}
public Integer getMarketCapitalization() {
	return marketCapitalization;
}
public void setMarketCapitalization(Integer marketCapitalization) {
	this.marketCapitalization = marketCapitalization;
}
public Integer getHeadcount() {
	return headcount;
}
public void setHeadcount(Integer headcount) {
	this.headcount = headcount;
}
public String getBrands() {
	return brands;
}
public void setBrands(String brands) {
	this.brands = brands;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public Nation getNation() {
	return nation;
}
public void setNation(Nation nation) {
	this.nation = nation;
}
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
public Figure getFounder() {
	return founder;
}
public void setFounder(Figure founder) {
	this.founder = founder;
}
public String getFrom() {
	return from != null?sdf.format(from):null;
}
public void setFrom(String from) {
	if(StringUtils.isNotEmpty(from)){
	try {
		this.from = sdf.parse(from);
	} catch (ParseException e) {
		e.printStackTrace();
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
	}
}
public Integer getAge() {
	return TimeManager. getAge(this.from,new Date());
}
}
