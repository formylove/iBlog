package main.src.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.SqlUtils;
@Component("genre")
@Entity
@Table(name = "genre")
public class Genre {
@Id	 @Column(name="genre_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private String type;
//@ManyToMany(targetEntity=Opus.class)
//@JoinTable(name="Opus_Genre",
//joinColumns=@JoinColumn(name="genre_id",referencedColumnName="genre_id"),
//inverseJoinColumns=@JoinColumn(name="opus_id",referencedColumnName="opus_id"))
//@Cascade(CascadeType.ALL)
//private Set<Opus> opuses = new HashSet<Opus>();
private boolean del_flag = false;
//public int hashCode() {
//	return id.hashCode()*31;
//}
//public boolean equals(Object o) {
//	return (o instanceof Genre && this.id == ((Genre) o).id);
//}

//public Set<Opus> getOpuses() {
//	return opuses;
//}
//public void setOpuses(Set<Opus> opuses) {
//	this.opuses = opuses;
//}
public void setId(Integer id) {
	this.id = id;
}
public boolean isDel_flag() {
	return del_flag;
}
public void setDel_flag(boolean del_flag) {
	this.del_flag = del_flag;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllGenre(boolean withDel){
	String sql = "select * from genre where " + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllBookGenre(boolean withDel){
	String sql = "select * from genre where type='book' and" + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
@SuppressWarnings("unchecked")
static public List<Genre> getAllMovieGenre(boolean withDel){
	String sql = "select * from genre where type='movie' and" + (withDel?"(del_flag=0 or del_flag=1)":"( del_flag<>1 )");
	return (List<Genre>)SqlUtils.executeQuery(sql, null, Genre.class);
}
}
