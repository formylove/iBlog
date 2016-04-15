package main.src.action;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.common.StrUtils;
import main.src.entity.Category;
import main.src.entity.Comment;
import main.src.entity.User;
import main.src.entity.essay.Essay;
import main.src.service.CategoryService;
import main.src.service.CommentService;
import main.src.service.EssayService;
public class EssayAction {
@Resource(name="essayService")
private EssayService essayService;
@Resource(name="commentService")
private CommentService commentService;
@Resource(name="categoryService")
private CategoryService categoryService;
private float w;
private float h;
private float x;
private float y;
String cover;
Essay essay;
List<Comment> comments;
String title;
//edit essay
int id;
Properties authorities = (new MsgConstants()).AUTHORITY;
boolean hasExisted;
//essay list
List<Essay> essays;
List<Essay> recommendations;
int page = 1;
int category;
Category cat;
List<Category> categories;
int pages;
User user;
boolean loginStatus;
public String list(){
	HttpServletRequest request=ServletActionContext.getRequest();
	categories = categoryService.list();
	if(category == 0){
		if(!categories.isEmpty()){
			cat = categories.get(0);
		}
	}else{
		cat = categoryService.get(category);
	}
	essays = essayService.getOnePage(page, category);
	pages = essayService.getPageCnt(category);
	return MsgConstants.LIST;
}
public String save() throws NumberFormatException, UnsupportedEncodingException{
    if(id==0){
    		if(!StrUtils.isEmpty(cover)){
    			essay.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NHORIZONTAL));
    		}
    		id = essayService.save(essay);
    		essay.setId(id);
    }else{
    	if(!essay.getCover().equals(cover)){
    		ImageUtils.deleteImg(essay.getCover());
    		essay.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NHORIZONTAL));
    	}
    	essayService.update(essay);
    }
		return MsgConstants.DISPLAY;
}

public String read(){
	    essayService.read(id);
	    return null;
}
public String load(){
	essay=essayService.get(id);
//	user = UserService.getcurLoginUser(null);
	essayService.read(id);
	int total = commentService.getLastUnit("essay",id);
	pages = total/commentService.PAGESIZE + (total%commentService.PAGESIZE == 0?0:1);
	comments = commentService.getOnePage(total,1,"essay",id);
	return MsgConstants.DISPLAY;
}

public String edit(){
	authorities = MsgConstants.AUTHORITY;
	essay = null;
	if(id!=0){
		essay=essayService.get(id);
	}
	
	return MsgConstants.SUCCESS;
}

public String like(){
	essayService.like(id);
	return null;
}

public String undoLike(){
	essayService.undoLike(id);
	return null;
}
public String delete(){
	essayService.remove(id);
	return null;
}

public String recover(){
    essayService.recover(id);
	return null;
}

@JSON(serialize=false)
public CommentService getCommentService() {
	return commentService;
}
public void setCommentService(CommentService commentService) {
	this.commentService = commentService;
}
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}
@JSON(serialize=false)
public EssayService getEssayService() {
	return essayService;
}
@JSON(serialize=false)
public CategoryService getCategoryService() {
	return categoryService;
}
public String hasExisted(){
	hasExisted = essayService.hasExisted(title);
	return MsgConstants.DONE;
}


public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}
public boolean isLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(boolean loginStatus) {
	this.loginStatus = loginStatus;
}
@JSON(serialize=false)
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@JSON(serialize=false)
public List<Essay> getRecommendations() {
	return recommendations;
}
@JSON(serialize=false)
public Properties getAuthorities() {
	return authorities;
}
public void setAuthorities(Properties authorities) {
	this.authorities = authorities;
}
public void setRecommendations(List<Essay> recommendations) {
	this.recommendations = recommendations;
}
public int getPage() {
	return page;
}
public Category getCat() {
	return cat;
}
public void setCat(Category cat) {
	this.cat = cat;
}
public List<Category> getCategories() {
	return categories;
}
public void setCategories(List<Category> categories) {
	this.categories = categories;
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
@JSON(serialize=false)
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

public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
@JSON(serialize=false)
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
public void setEssayService(EssayService essayService) {
	this.essayService = essayService;
}
public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}

}
