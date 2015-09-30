package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.common.StringUtils;
import main.src.entity.Category;
import main.src.entity.User;
import main.src.entity.essay.Essay;
import main.src.service.CategoryService;
import main.src.service.EssayService;
import main.src.service.UserService;
public class EssayAction {
private float w;
private float h;
private float x;
private float y;
String profile;
Essay essay;
String title;
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
User user;
boolean loginStatus;
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
    if(id==0){
    	if(!StringUtils.isEmpty(profile)){
    		essay.setProfile(ImageUtils.cut(profile, w, h, x, y));
    	}
    	id = EssayService.saveEssay(essay);
    }else{
    	if(!essay.getProfile().equals(profile)){
    		ImageUtils.deleteImg(essay.getProfile());
    		essay.setProfile(ImageUtils.cut(profile, w, h, x, y));
    	}
    	EssayService.updateEssay(id, essay);
    }
		return MsgConstants.ESSAYPAGE;
}

public String readEssay(){
	    EssayService.readEssay(id);
	    return null;
}
public String loadEssay(){
	essay=EssayService.getEssay(id);
	user = UserService.getcurLoginUser(null);
	EssayService.readEssay(id);
	return MsgConstants.ESSAYPAGE;
}

public String editEssay(){
	if(id!=0){
		essay=EssayService.getEssay(id);
	}
	categories = CategoryService.getAllCategories(true);
	
	return "editessay";
}

public String deleteEssay(){
	EssayService.deleteEssay(id);
	essay = EssayService.getEssay(id);
	return MsgConstants.DELETED;
}

public String recoverEssay(){
	EssayService.recoverEssay(id);
	return MsgConstants.RECOVERED;
}

public String hasExisted(){
	hasExisted = EssayService.hasExisted(title);
	return MsgConstants.REDUPLICATIVE;
}
public String like(){
	EssayService.likeEssay(id);
	return MsgConstants.LIKE;
}

public String undoLike(){
	EssayService.undoLikeEssay(id);
	return MsgConstants.LIKE;
}


public boolean isLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(boolean loginStatus) {
	this.loginStatus = loginStatus;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
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


public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}

public boolean isHasExisted() {
	return hasExisted;
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


public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}
public float getW() {
	return w;
}
public void setW(float w) {
	this.w = w;
}
public float getH() {
	return h;
}
public void setH(float h) {
	this.h = h;
}
public float getX() {
	return x;
}
public void setX(float x) {
	this.x = x;
}
public float getY() {
	return y;
}
public void setY(float y) {
	this.y = y;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}

}
