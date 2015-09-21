package main.src.entity.note;

import main.src.common.TimeManager;

public class Opus{
	public int id;
	public String name;
	public String original_name;
	public String cover;
	public String rating;
	public boolean rec_flag;
	public String nationality;
	public String dynasty;
	public String author_directior;
	public String protagonists;
	public String genre;
	public String publish_date;
	public String view_time;
	public String create_date;
	public String create_time;
	public boolean del_flag;
	public boolean single_flag;
	public Opus(){
		setCreate_date(TimeManager.getDate());
		setCreate_time(TimeManager.getTime());
	}
	public String toString(){
		return "id: " + id + "\n" + "create_date: " + create_date + "\n" + "genre: " + genre
				+ "\n" + "create_time: " + create_time + "\n" + "del_flag: " + del_flag
				+ "\n" + "cover:" +cover+"\nworks_name:"+name+"\nnationality:"+nationality+"\ndynasty:"+dynasty+"\nrating:"+rating+ "\n" + "author_directior:"+author_directior
				+"\n" + "protagonists:"+protagonists + "\npublish_date:"+publish_date + "\nrec_flag:"+rec_flag + "\nrating:"+rating+ "\nsingle_flag:"+single_flag;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setGenre(String[] genre) {
		this.genre = genre[0];
	}
	public boolean isSingle_flag() {
		return single_flag;
	}
	public void setSingle_flag(boolean single_flag) {
		this.single_flag = single_flag;
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
	public void setId(int id) {
		this.id = id;
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
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
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
		this.protagonists = protagonists;
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
