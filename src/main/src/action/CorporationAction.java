package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.gallery.Corporation;
import main.src.service.CorporationService;
import net.sf.json.JSONArray;

public class CorporationAction {
	@Resource(name="corporationService")
	private CorporationService corporationService;
	Corporation corporation = null;
	int id;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	private String industry;
	private JSONArray tree;
	public String list(){
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		if(StringUtils.isNotEmpty(cover)){
	    			corporation.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NHORIZONTAL));
	    		}
	    		id = corporationService.save(corporation);
	    		corporation.setId(id);
	    }else{
	    	if(!corporation.getCover().equals(cover)){
	    		ImageUtils.deleteImg(corporation.getCover());
	    		corporation.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NHORIZONTAL));
	    	}
	    	corporationService.update(corporation);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	corporation = corporationService.get(id);
	return MsgConstants.DISPLAY;
}
public String tree(){ 
	tree = corporationService.getTree(industry);
	return MsgConstants.DONE;
}

public String edit(){
	corporation = null;
	if(id!=0){
		corporation = corporationService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	corporation = corporationService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public CorporationService getCorporationService() {
	return corporationService;
}
public void setCorporationService(CorporationService corporationService) {
	this.corporationService = corporationService;
}
@JSON(serialize=false)
public Corporation getCorporation() {
	return corporation;
}
public void setCorporation(Corporation corporation) {
	this.corporation = corporation;
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
public String getIndustry() {
	return industry;
}
public void setIndustry(String industry) {
	this.industry = industry;
}
public JSONArray getTree() {
	return tree;
}
public void setTree(JSONArray tree) {
	this.tree = tree;
}
	
}
