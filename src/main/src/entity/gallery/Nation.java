package main.src.entity.gallery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.TimeManager;
import main.src.entity.gallery.item.Figure;
import main.src.entity.gallery.item.Scenery;

@Component("nation")
@Entity
@Table(name = "nation")
public class Nation{
	@Id @Column(name="nation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cover;
	private String name;
	private String name_en;
	private boolean zhonghua = false;
	@OneToOne(targetEntity = City.class)
	@JoinColumn(name="capital_id")
	private City capital;
	private String currency;
	private String currency_en;
	private String language;
	@OneToOne(targetEntity = People.class)
	@JoinColumn(name="people_id")
	private People people;
	@OneToOne(targetEntity = Religion.class)
	@JoinColumn(name="religion_id")
	private Religion religion;
	@Temporal(TemporalType.DATE )
	@Column(name = "[from]")
	private Date from;
	@Temporal(TemporalType.DATE )
	private Date perish;
	private Integer age;
	private Integer population;
	private Integer GDP;
	private Integer area;
	@OneToOne(targetEntity = Figure.class)
	@JoinColumn(name="president_id")
	private Figure president;
	@OneToOne(targetEntity = Figure.class)
	@JoinColumn(name="founder_id")
	private Figure founder;
	@Enumerated(EnumType.ORDINAL)
	private Continent continent;
	@OneToMany(targetEntity=Scenery.class,mappedBy="nation")
	private Set<Scenery> sceneries = new HashSet<Scenery>();
	private String profile;
	@Transient
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public Nation() {
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
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

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCurrency_en() {
		return currency_en;
	}
	public void setCurrency_en(String currency_en) {
		this.currency_en = currency_en;
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
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String[] id) {
		this.id = Integer.parseInt(id[0]);
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
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getGDP() {
		return GDP;
	}
	public void setGDP(Integer gDP) {
		GDP = gDP;
	}
	public Figure getPresident() {
		return president;
	}
	public void setPresident(Figure president) {
		this.president = president;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getContinent() {
		return continent.getName();
	}
//	public void setContinent(Continent continent) {
//		System.out.println("continent Continent");
//		this.continent = continent;
//	}
//	public void setContinent(String continent) {
//		System.out.println("continent String");
//		this.continent = Continent.get(continent);
//	}           
	public void setContinent(String[] continent) {
		System.out.println("continent String[]");
		this.continent = Continent.get(continent[0]);
	}
	public Set<Scenery> getSceneries() {
		return sceneries;
	}
	public void setSceneries(Set<Scenery> sceneries) {
		this.sceneries = sceneries;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public void setPerish(Date perish) {
		this.perish = perish;
	}
	public boolean isZhonghua() {
		return zhonghua;
	}
	public void setZhonghua(boolean zhonghua) {
		this.zhonghua = zhonghua;
	}
	
}
