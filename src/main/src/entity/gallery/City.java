package main.src.entity.gallery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component("city")
@Entity
@Table(name = "city")
public class City {
	@Id @Column(name="city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String name_en;
	private String name_old;
	private String alias;
	private String profile;
	//Ï½ÏÂµØÇø
	private String under;
	private Integer population;
	private Integer GDP;
	private Integer area;
	@OneToOne(targetEntity = Nation.class)
	@JoinColumn(name="nation_id")
	private Nation nation;
	@OneToOne(targetEntity = State.class)
	@JoinColumn(name="state_id")
	private State state;
	public City() {
	}
	
	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public String getUnder() {
		return under;
	}

	public void setUnder(String under) {
		this.under = under;
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

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
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
	public String getName_old() {
		return name_old;
	}
	public void setName_old(String name_old) {
		this.name_old = name_old;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
}
