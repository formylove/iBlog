package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.gallery.Continent;
import main.src.entity.gallery.Nation;
import main.src.service.GenreService;
import main.src.service.NationService;

public class NationAction3 {
	@Resource(name="nationService")
	private NationService nationService;
	Nation nation = null;
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
	    			nation.setCover(ImageUtils.cut(cover, w, h, x, y));
	    		}
	    		id = nationService.save(nation);
	    		nation.setId(id);
	    }else{
	    	if(!nation.getCover().equals(cover)){
	    		ImageUtils.deleteImg(nation.getCover());
	    		nation.setCover(ImageUtils.cut(cover, w, h, x, y));
	    	}
	    	nationService.update(nation);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	nation = nationService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){
	nation = null;
	if(id!=0){
		nation = nationService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	nation = nationService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public NationService getNationService() {
	return nationService;
}
public void setNationService(NationService nationService) {
	this.nationService = nationService;
}
@JSON(serialize=false)
public Nation getNation() {
	return nation;
}
public void setNation(Nation nation) {
	System.out.println("ai?");
	this.nation = nation;
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
