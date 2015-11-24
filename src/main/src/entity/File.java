package main.src.entity;

public class File {
	int id;
	String name;
	String size;
	String profile;
	String link;
	String create_date;
	String create_time;
	boolean del_flag;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public boolean isDel_flag() {
		return del_flag;
	}
	public void setDel_flag(boolean del_flag) {
		this.del_flag = del_flag;
	}

	
}
