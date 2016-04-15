package main.src.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.Poster;
import main.src.service.PosterService;

public class PosterAction {
	@Resource(name="posterService")
	private PosterService posterService;
	Poster poster = null;
	List<Poster> posters = null;
	int id;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	private String ids;
	public String list(){
		posters = posterService.list();
		return MsgConstants.LIST;
	}
	public String update(){
		int after = 1;
		for(String before : ids.split(",")){
			posterService.updateOrder(Integer.valueOf(before), after);
			after++;
		}
		return MsgConstants.DONE;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		if(StringUtils.isNotEmpty(cover)){
	    			poster.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.POSTER));
	    		}
	    		id = posterService.save(poster);
	    		poster.setId(id);
	    }else{
	    	if(!poster.getCover().equals(cover)){
	    		ImageUtils.deleteImg(poster.getCover());
	    		poster.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.POSTER));
	    	}
	    	posterService.update(poster);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	poster = posterService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){
	posters = posterService.list();
	poster = null;
	if(id!=0){
		poster = posterService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	poster = posterService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public PosterService getPosterService() {
	return posterService;
}
public void setPosterService(PosterService posterService) {
	this.posterService = posterService;
}
@JSON(serialize=false)
public Poster getPoster() {
	return poster;
}
public void setPoster(Poster poster) {
	System.out.println("ai?");
	this.poster = poster;
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
public String getIds() {
	return ids;
}
public void setIds(String ids) {
	this.ids = ids;
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
@JSON(serialize=false)
public List<Poster> getPosters() {
	return posters;
}
public void setPosters(List<Poster> posters) {
	this.posters = posters;
}
	
}
