package main.src.entity.note;

import java.util.LinkedHashMap;
import java.util.Map;

import main.src.common.StringUtils;
import main.src.common.TimeManager;
import main.src.service.NoteService;

public class Opus{
	public int id;
	public String name;
	public String original_name;
	public String cover;
	public String rating;
	public boolean rec_flag;
	public String remark;
	public String nationality;
	public String dynasty;
	public String author_directior;
	public String protagonists;
	public Integer genre;
	public String type;
	public String publish_date;
	public String view_time;
	public String create_date;
	public String create_time;
	public boolean del_flag;
	public boolean single_flag;
	private final String splitTag = ",";
	private Map<String,String> meta;
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
	
	public Map<String,String> getMeta() {
		meta = new LinkedHashMap<String,String>();
		if(isBook()){
			meta.put("书名", name);
			
			if("中国".equals(nationality)){
				if(!"nope".equals(dynasty)){
					meta.put("作家", author_directior+"("+dynasty+")");
				}else{
					if(!StringUtils.isEmpty(author_directior)){
						meta.put("作家", author_directior);
					}
				}
				
			}else if(!"nope".equals(nationality)){
				meta.put("作家", author_directior+"("+nationality+")");
				if(!StringUtils.isEmpty(original_name)){
					meta.put("译名", original_name);
				}
				
			}else{
				if(!StringUtils.isEmpty(author_directior)){
					meta.put("作家", author_directior);
				}
			}
			if(!StringUtils.isEmpty(protagonists)){
				meta.put("主角", protagonists);
			}
			if(genre !=0){
				meta.put("类型", NoteService.getGenreName(genre));
			}
		}else{
				if(!"中国".equals(nationality) && !"nope".equals(nationality)){
						meta.put("电影名", name+"("+nationality+")");
						if(!StringUtils.isEmpty(original_name)){
							meta.put("译名", original_name);
						}
						
				}else {
					meta.put("电影名", name);
				}
				if(!StringUtils.isEmpty(author_directior)){
					meta.put("导演", author_directior);
				}
				if(!StringUtils.isEmpty(protagonists)){
					meta.put("主演", protagonists);
				}
				if(rec_flag){
					if(!StringUtils.isEmpty(remark)){
						meta.put("推荐评语", remark);
					}
				}
					if(!StringUtils.isEmpty(rating)){
						meta.put("评价", rating);
					}
				if(genre !=0){
					meta.put("类型", NoteService.getGenreName(genre));
				}
				if(!StringUtils.isEmpty(publish_date)){
					meta.put("上映时间", publish_date+"月");
				}
		}
		return meta;
	}
	
	public boolean isBook(){
		if("book".equals(type)){
			return true;
		}else{
			return false;
		}
	}
	public String[] getAllProtagonists(){
		if(!StringUtils.isEmpty(protagonists)){
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
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
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
		if(StringUtils.notEmpty(protagonists)){
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
