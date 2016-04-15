package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.gallery.City;
import main.src.service.CityService;
import net.sf.json.JSONArray;

public class CityAction {
	@Resource(name="cityService")
	private CityService cityService;
	private JSONArray tree;
	City city = null;
	int id;
	public String list(){
//		notes = (Essay) EssayService.getOnePage(page, category, null, false);
//		recommendations = EssayService.getRecommendation(category);
//		pages = EssayService.getPageCnt(false,category);
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		id = cityService.save(city);
	    		city.setId(id);
	    }else{
	    	cityService.update(city);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	city = cityService.get(id);
	return MsgConstants.DISPLAY;
}
public String tree(){
	tree = cityService.getTree();
	System.out.println(tree);
	return MsgConstants.DONE;
}
public String edit(){
	city = null;
	if(id!=0){
		city = cityService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	city = cityService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public CityService getCityService() {
	return cityService;
}
public void setCityService(CityService cityService) {
	this.cityService = cityService;
}
@JSON(serialize=false)
public City getCity() {
	return city;
}
public void setCity(City city) {
	System.out.println("ai?");
	this.city = city;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public JSONArray getTree() {
	return tree;
}
public void setTree(JSONArray tree) {
	this.tree = tree;
}
	
}
