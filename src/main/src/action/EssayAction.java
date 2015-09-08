package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import main.src.common.MsgConstants;
import main.src.common.SqlUtils;
import main.src.common.TimeManager;
import main.src.entity.Category;
import main.src.entity.essay.Essay;
import main.src.service.CategoryService;
import main.src.service.EssayService;
public class EssayAction {
Essay essay;
String editor;
String title;
String author;
String label;
int categoryId;
int authority;
int music;
String original_link;
boolean isOriginal;
//edit essay
int id;
List<Category> categories;
boolean essayCheckflag = false;
boolean hasExisted;
//essay list
List<Essay> essays;
public String listEssay(){
	essays = EssayService.getAllDiaries(true);
	
	return MsgConstants.Essays;
}
public String saveEssay() throws NumberFormatException, UnsupportedEncodingException{
	Map<String,Object> data=new HashMap<String,Object>();
		data.put("title", title);
		data.put("author", author);
		data.put("music", music);
		if(label!=null){
			data.put("label", label);
		}
		data.put("category", categoryId);
		data.put("content", editor);
		data.put("original_flag", isOriginal);
		if(original_link!=null){
			data.put("original_link", original_link);
		}
		data.put("authority", authority);
		if(id==0){//创建日志
			data.put("create_date", TimeManager.getDate());
			data.put("create_time", TimeManager.getTime());
			SqlUtils.executeInsert(data, "essay");
			int essayId = EssayService.getLatestEssayId();
			essay=EssayService.getEssay(essayId);
		}else{//修改文章
			SqlUtils.executeUpdate(data, "essay", "id ="+id);
			essay=EssayService.getEssay(id);
		}
		return MsgConstants.ESSAYPAGE;
}

public String loadEssay(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int essayId=Integer.parseInt(request.getParameter("id"));
	    essay=EssayService.getEssay(essayId);
	    if(essay.author_desc.length()>30){
	    	essay.author_desc = essay.author_desc.substring(0, 29) + "...";
	    }
	
	return MsgConstants.ESSAYPAGE;
}

public String editEssay(){
	
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	essay=EssayService.getEssay(essayId);
	categories = CategoryService.getAllCategories(true);
	
	return "editessay";
}

public String deleteEssay(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	EssayService.deleteEssay(essayId);
	essay = EssayService.getEssay(essayId);
	return MsgConstants.DELETED;
}

public String recoverEssay(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	EssayService.recoverEssay(essayId);
	return MsgConstants.RECOVERED;
}

public String hasExisted(){
	hasExisted = EssayService.hasExisted(title);
	return MsgConstants.REDUPLICATIVE;
}
public String like(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	EssayService.likeEssay(essayId);
	return MsgConstants.LIKE;
}

public String undoLike(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=(request.getParameter("id")==null)?0:Integer.parseInt(request.getParameter("id"));
	EssayService.undoLikeEssay(essayId);
	return MsgConstants.LIKE;
}


public List<Essay> getEssays() {
	return essays;
}
public void setEssays(List<Essay> essays) {
	this.essays = essays;
}
public int getMusic() {
	return music;
}

public void setMusic(int music) {
	this.music = music;
}

public boolean isEssayCheckflag() {
	return essayCheckflag;
}

public void setEssayCheckflag(boolean essayCheckflag) {
	this.essayCheckflag = essayCheckflag;
}

public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}

public boolean isHasExisted() {
	return hasExisted;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public int getAuthority() {
	return authority;
}

public void setAuthority(int authority) {
	this.authority = authority;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public List<Category> getCategories() {
	return categories;
}

public void setCategories(List<Category> categories) {
	this.categories = categories;
}

public Essay getEssay() {
	return essay;
}

public void setEssay(Essay essay) {
	this.essay = essay;
}

public String getEditor() {
	return editor;
}

public void setEditor(String editor) {
	this.editor = editor;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public String getOriginal_link() {
	return original_link;
}

public void setOriginal_link(String original_link) {
	this.original_link = original_link;
}

public boolean isOriginal() {
	return isOriginal;
}

public void setOriginal(boolean isOriginal) {
	this.isOriginal = isOriginal;
}


}
