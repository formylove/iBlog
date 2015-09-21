package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import main.src.common.MsgConstants;
import main.src.common.SqlUtils;
import main.src.common.StringUtils;
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
Map<String, String> authorities = (new MsgConstants()).AUTHORITY;
List<Category> categories;
boolean hasExisted;
//essay list
List<Essay> essays;
List<Essay> recommendations;
int page;
int pages;
String category;
public String listEssay(){
	HttpServletRequest request=ServletActionContext.getRequest();
	String[] categories =  request.getParameterValues("category");
	System.out.println("cat  "+category);
	essays = EssayService.getOnePage(page, categories, null, false);
	recommendations = EssayService.getRecommendation(categories);
	pages = EssayService.getPageCnt(false,categories);
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
			int essayId = SqlUtils.executeInsert(data, "essay");
			essay=EssayService.getEssay(essayId);
		}else{//修改文章
			SqlUtils.executeUpdate(data, "essay", "id ="+id);
			essay=EssayService.getEssay(id);
		}
		return MsgConstants.ESSAYPAGE;
}

public String readEssay(){
	    EssayService.readEssay(id);
	    return null;
}
public String loadEssay(){
	HttpServletRequest request=ServletActionContext.getRequest();
	int essayId=Integer.parseInt(request.getParameter("id"));
	essay=EssayService.getEssay(essayId);
	EssayService.readEssay(essayId);
	StringUtils.truncate(essay.author_desc, 30);
	
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


public Map<String, String> getAuthorities() {
	return authorities;
}
public void setAuthorities(Map<String, String> authorities) {
	this.authorities = authorities;
}
public List<Essay> getRecommendations() {
	return recommendations;
}
public void setRecommendations(List<Essay> recommendations) {
	this.recommendations = recommendations;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getPages() {
	return pages;
}
public void setPages(int pages) {
	this.pages = pages;
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
