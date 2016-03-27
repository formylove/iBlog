/**
 * 
 */
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

/**
 * @author Administrator
 *
 */
@Component("religion")
@Entity
@Table(name = "religion")
public class Religion{
	@Id @Column(name="religion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String name_en;
	@OneToOne(targetEntity = Figure.class)
	@JoinColumn(name="founder_id")
	private Figure founder;
	@OneToOne(targetEntity = Nation.class)
	@JoinColumn(name="birthplace_id")
	private Nation birthplace;
	private Integer votaryNum;
	@OneToOne(targetEntity = City.class)
	@JoinColumn(name="pilgrimplace_id")
	private City pilgrimplace;
	@Temporal(TemporalType.DATE )
	@Column(name = "[from]")
	private Date from;
	private String profile;
	@Transient
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public Religion() {
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
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public Figure getFounder() {
		return founder;
	}
	public void setFounder(Figure founder) {
		this.founder = founder;
	}
	public Nation getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(Nation birthplace) {
		this.birthplace = birthplace;
	}
	public Integer getVotaryNum() {
		return votaryNum;
	}
	public void setVotaryNum(Integer votaryNum) {
		this.votaryNum = votaryNum;
	}
	public City getPilgrimplace() {
		return pilgrimplace;
	}
	public void setPilgrimplace(City pilgrimplace) {
		this.pilgrimplace = pilgrimplace;
	}
	public void setFrom(Date from) {
		this.from = from;
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
