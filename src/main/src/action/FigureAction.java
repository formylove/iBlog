package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.annotations.JSON;

import main.src.common.ImageUtils;
import main.src.common.MsgConstants;
import main.src.entity.gallery.item.Figure;
import main.src.service.FigureService;
import net.sf.json.JSONArray;

public class FigureAction {
	@Resource(name="figureService")
	private FigureService figureService;
	Figure figure = null;
	int id;
	private float w;
	private float h;
	private float x;
	private float y;
	private String cover;
	private String domain;
	private JSONArray tree;
	public String list(){
//		notes = (Essay) EssayService.getOnePage(page, category, null, false);
//		recommendations = EssayService.getRecommendation(category);
//		pages = EssayService.getPageCnt(false,category);
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		if(StringUtils.isNotEmpty(cover)){
	    			figure.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NVERTICAL));
	    		}
	    		id = figureService.save(figure);
	    		figure.setId(id);
	    }else{
	    	if(!figure.getCover().equals(cover)){
	    		ImageUtils.deleteImg(figure.getCover());
	    		figure.setCover(ImageUtils.cut(cover, w, h, x, y,ImageUtils.NVERTICAL));
	    	}
	    	figureService.update(figure);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	figure = figureService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){ 
	figure = null;
	if(id!=0){
		figure = figureService.get(id);
	}
	return MsgConstants.SUCCESS;
}
public String tree(){ 
	tree = figureService.getTree(domain);
	return MsgConstants.DONE;
}

public String delete(){
	figure = figureService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public FigureService getFigureService() {
	return figureService;
}
public void setFigureService(FigureService figureService) {
	this.figureService = figureService;
}
@JSON(serialize=false)
public Figure getFigure() {
	return figure;
}
public void setFigure(Figure figure) {
	System.out.println("ai?");
	this.figure = figure;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDomain() {
	return domain;
}
public void setDomain(String domain) {
	this.domain = domain;
}
public JSONArray getTree() {
	return tree;
}
public void setTree(JSONArray tree) {
	this.tree = tree;
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
