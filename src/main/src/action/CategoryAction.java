package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.Category;
import main.src.service.CategoryService;

public class CategoryAction {
	@Resource(name="categoryService")
	private CategoryService categoryService;
	Category category = null;
	int id;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	public String list(){
//		notes = (Essay) EssayService.getOnePage(page, category, null, false);
//		recommendations = EssayService.getRecommendation(category);
//		pages = EssayService.getPageCnt(false,category);
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		if(StringUtils.isNotEmpty(cover)){
	    			category.setCover(ImageUtils.cut(cover, w, h, x, y));
	    		}
	    		id = categoryService.save(category);
	    		category.setId(id);
	    }else{
	    	if(!category.getCover().equals(cover)){
	    		ImageUtils.deleteImg(category.getCover());
	    		category.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	categoryService.update(category);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	category = categoryService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){
	category = null;
	if(id!=0){
		category = categoryService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	category = categoryService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public CategoryService getCategoryService() {
	return categoryService;
}
public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}
@JSON(serialize=false)
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	System.out.println("ai?");
	this.category = category;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getCover() {
	return cover;
}
public void setCover(String cover) {
	this.cover = cover;
}
	
}
