package main.src.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.Category;
import main.src.entity.Genre;
import main.src.service.CategoryService;
import main.src.service.GenreService;

public class GenreAction {
	@Resource(name="categoryService")
	private CategoryService categoryService;
	@Resource(name="genreService")
	private GenreService genreService;
	Genre genre = null;
	List<Category> categories = null;
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
	    		id = genreService.save(genre);
	    		genre.setId(id);
	    }else{
	    	genreService.update(genre);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	genre = genreService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){
	categories = categoryService.list();
	genre = null;
	if(id!=0){
		genre = genreService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	genre = genreService.remove(id);
	return MsgConstants.DONE;
}

public void setCategoryService(CategoryService categoryService) {
	this.categoryService = categoryService;
}
@JSON(serialize=false)
public List<Category> getCategories() {
	return categories;
}
public void setCategories(List<Category> categories) {
	this.categories = categories;
}
@JSON(serialize=false)
public GenreService getGenreService() {
	return genreService;
}
public void setGenreService(GenreService genreService) {
	this.genreService = genreService;
}
@JSON(serialize=false)
public Genre getGenre() {
	return genre;
}
public void setGenre(Genre genre) {
	System.out.println("ai?");
	this.genre = genre;
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
