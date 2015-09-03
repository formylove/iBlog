package main.src.entity.diary;

import main.src.entity.Diary;

public class Zhihu extends Diary {
	int id;
	String title;
	String subtitle;
	String author;
	String author_link;
	String author_desc;
	String profile;
	String label;
	int category;
	String content;
	int read_cnt;
	int favor_cnt;
	boolean original_flag;
	String original_link;
	int music;
	String portrait;
	String create_date;
	String create_time;
	int authority;
	boolean del_flag;

	public Zhihu(){
		super();//必须放在第一句
		setOriginal_flag(false);
	};

	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAuthor_link() {
		return author_link;
	}
	public void setAuthor_link(String author_link) {
		this.author_link = author_link;
	}
	public String getAuthor_desc() {
		return author_desc;
	}
	public void setAuthor_desc(String author_desc) {
		this.author_desc = author_desc;
	}
	public int getMusic() {
		return music;
	}
	public void setMusic(int music) {
		this.music = music;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public int getFavor_cnt() {
		return favor_cnt;
	}
	public void setFavor_cnt(int favor_cnt) {
		this.favor_cnt = favor_cnt;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isOriginal_flag() {
		return original_flag;
	}
	public void setOriginal_flag(boolean original_flag) {
		this.original_flag = original_flag;
	}
	public String getOriginal_link() {
		return original_link;
	}
	public void setOriginal_link(String original_link) {
		this.original_link = original_link;
	}

	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public boolean isDel_flag() {
		return del_flag;
	}
	public void setDel_flag(boolean del_flag) {
		this.del_flag = del_flag;
	}
	public int getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(int read_cnt) {
		this.read_cnt = read_cnt;
	}


}
