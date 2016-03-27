package main.src.entity.gallery.item;

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

import main.src.entity.gallery.City;
import main.src.entity.gallery.Nation;
import main.src.entity.gallery.State;

@Component("scenery")
@Entity
@Table(name = "scenery")
public class Scenery {
	@Id @Column(name="scenery_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String portrait;
	private String name;
	private String name_en;
	private String profile;
	private boolean exhibit_flag = true;
	@OneToOne(targetEntity = Nation.class)
	@JoinColumn(name="nation_id" , referencedColumnName="nation_id",nullable=false)
	private Nation nation;
	@OneToOne(targetEntity = State.class)
	@JoinColumn(name="state_id")
	private State state;
	@OneToOne(targetEntity = City.class)
	@JoinColumn(name="city_id")
	private City city;
	public Scenery() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
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
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
