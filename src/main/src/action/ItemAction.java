package main.src.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.Genre;
import main.src.entity.Opus;
import main.src.service.GenreService;
import main.src.service.OpusService;

public class ItemAction {
	@Resource(name="opusService")
	private OpusService opusService;
	@Resource(name="genreService")
	private GenreService genreService;
	Opus opus = null;
	int id;
	List<Genre> genres;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	private String name;
	private boolean hasExisted;
	public String list(){
//		notes = (Essay) EssayService.getOnePage(page, category, null, false);
//		recommendations = EssayService.getRecommendation(category);
//		pages = EssayService.getPageCnt(false,category);
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		if(StringUtils.isNotEmpty(cover)){
	    			opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    		}
	    		id = opusService.save(opus);
	    		opus.setId(id);
	    }else{
	    	if(!opus.getCover().equals(cover)){
	    		ImageUtils.deleteImg(opus.getCover());
	    		opus.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	opusService.update(opus);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	opus = opusService.get(id);
	return MsgConstants.DISPLAY;
}
public String emovie(){
	opus = null;
	if(id!=0){
		opus = opusService.get(id);
	}
	genres = (List<Genre>) genreService.getAll(false);
	return "emovie";
}
public String ebook(){
	opus = null;
	if(id!=0){
		opus = opusService.get(id);
	}
	genres = (List<Genre>) genreService.getAll(false);
	return "ebook";
}

public String delete(){
	opus = opusService.remove(id);
	return MsgConstants.DONE;
}
public String hasExisted(){
	hasExisted = opusService.hasExisted(name);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public OpusService getOpusService() {
	return opusService;
}
public void setOpusService(OpusService opusService) {
	this.opusService = opusService;
}
@JSON(serialize=false)
public GenreService getGenreService() {
	return genreService;
}
public void setGenreService(GenreService genreService) {
	this.genreService = genreService;
}
@JSON(serialize=false)
public Opus getOpus() {
	return opus;
}
public void setOpus(Opus opus) {
	System.out.println("ai?");
	this.opus = opus;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@JSON(serialize=false)
public List<Genre> getGenres() {
	return genres;
}
public void setGenres(List<Genre> genres) {
	this.genres = genres;
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
public boolean isHasExisted() {
	return hasExisted;
}
public void setHasExisted(boolean hasExisted) {
	this.hasExisted = hasExisted;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
	
	
}
