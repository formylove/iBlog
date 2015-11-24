package main.src.entity;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.stereotype.Component;

import main.src.common.StrUtils;
import main.src.common.TimeManager;
import main.src.service.NoteService;
@Component("opus")
@Entity
@Table(name = "o")
public class Opus{
	@Id @Column(name="opus_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String original_name;
	private String rating;
	private boolean rec_flag = false;
	private String remark;
	private String nationality;
	private String dynasty;
	private String author_directior;
	private String protagonists;
	@ManyToMany(targetEntity=Genre.class)
	@JoinTable(name="Opus_Genre",
	joinColumns=@JoinColumn(name="opus_id",referencedColumnName="opus_id"),
	inverseJoinColumns=@JoinColumn(name="genre_id",referencedColumnName="genre_id"))
	@Cascade(CascadeType.ALL)
	private Set<Genre> genres = new HashSet<Genre>();
	private String type;
	private String publish_date;
	private String view_time;
	@Column(updatable=false)
	private String create_date;
	@Column(updatable=false)
	private String create_time;
	private boolean del_flag = false;
	@OneToMany(targetEntity=Note.class,mappedBy="opus")
	private Set<Note> notes = new HashSet<Note>();
	@Transient
	private final String splitTag = ",";
	@Transient
	private Map<String,String> meta;
	public Opus(){
		setCreate_date(TimeManager.getDate());
		setCreate_time(TimeManager.getTime());
	}
	
	public Opus(String original_name, String remark) {
		super();
		System.out.println("opus created");
		this.original_name = original_name;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Opus [id=" + id + ", name=" + name + ", original_name=" + original_name 
				+ ", rating=" + rating + ", rec_flag=" + rec_flag + ", remark=" + remark + ", nationality="
				+ nationality + ", dynasty=" + dynasty + ", author_directior=" + author_directior + ", protagonists="
				+ protagonists + ", genre=" + genres.size() + ", type=" + type + ", publish_date=" + publish_date
				+ ", view_time=" + view_time + ", create_date=" + create_date + ", create_time=" + create_time
				+ ", del_flag=" + del_flag + ", isSingle=" + (notes.size() == 0) + ", splitTag=" + splitTag + ", meta="
				+ meta + "]";
	}
	public int hashCode() {
		return id.hashCode()*31;
	}
	public boolean equals(Object o) {
		return (o instanceof Opus && this.id == ((Opus) o).id);
	}
	public Map<String,String> getMeta() {
		meta = new LinkedHashMap<String,String>();
		if(isBook()){
			meta.put("书名", name);
			
			if("中国".equals(nationality)){
				if(!"nope".equals(dynasty)){
					meta.put("作家", author_directior+"("+dynasty+")");
				}else{
					if(!StrUtils.isEmpty(author_directior)){
						meta.put("作家", author_directior);
					}
				}
				
			}else if(!"nope".equals(nationality)){
				meta.put("作家", author_directior+"("+nationality+")");
				if(!StrUtils.isEmpty(original_name)){
					meta.put("译名", original_name);
				}
				
			}else{
				if(!StrUtils.isEmpty(author_directior)){
					meta.put("作家", author_directior);
				}
			}
			if(!StrUtils.isEmpty(protagonists)){
				meta.put("主角", protagonists);
			}
			if(genres.isEmpty()){
//				meta.put("类型", NoteService.getGenreName(genre));
			}
		}else{
				if(!"中国".equals(nationality) && !"nope".equals(nationality)){
						meta.put("电影名", name+"("+nationality+")");
						if(!StrUtils.isEmpty(original_name)){
							meta.put("译名", original_name);
						}
						
				}else {
					meta.put("电影名", name);
				}
				if(!StrUtils.isEmpty(author_directior)){
					meta.put("导演", author_directior);
				}
				if(!StrUtils.isEmpty(protagonists)){
					meta.put("主演", protagonists);
				}
				if(rec_flag){
					if(!StrUtils.isEmpty(remark)){
						meta.put("推荐评语", remark);
					}
				}
					if(!StrUtils.isEmpty(rating)){
						meta.put("评价", rating);
					}
				if(genres.isEmpty()){
//					meta.put("类型", NoteService.getGenreName(genre));
				}
				if(!StrUtils.isEmpty(publish_date)){
					meta.put("上映时间", publish_date+"月");
				}
		}
		return meta;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isBook(){
		if("book".equals(type)){
			return true;
		}else{
			return false;
		}
	}
	public String[] getAllProtagonists(){
		if(!StrUtils.isEmpty(protagonists)){
			return protagonists.trim().split(splitTag);
		}else{
			return null;
		}
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
   	public Set<Note> getNotes() {
		return notes;
	}

	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

	public String getDynasty() {
		return dynasty;
	}
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public boolean isRec_flag() {
		return rec_flag;
	}
	public void setRec_flag(boolean rec_flag) {
		this.rec_flag = rec_flag;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAuthor_directior() {
		return author_directior;
	}
	public void setAuthor_directior(String author_directior) {
		this.author_directior = author_directior;
	}
	public String getProtagonists() {
		return protagonists;
	}
	public void setProtagonists(String protagonists) {
		if(StrUtils.notEmpty(protagonists)){
			this.protagonists = protagonists.replaceAll(" ","").replaceAll(splitTag+"+$", "");
		}else{
			this.protagonists = protagonists;
		}
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public String getView_time() {
		return view_time;
	}
	public void setView_time(String view_time) {
		this.view_time = view_time;
	}
	public boolean isDel_flag() {
		return del_flag;
	}
	public void setDel_flag(boolean del_flag) {
		this.del_flag = del_flag;
	}

}
