package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.gallery.Religion;
import main.src.service.ReligionService;
import net.sf.json.JSONArray;

public class ReligionAction {
	@Resource(name="religionService")
	private ReligionService religionService;
	Religion religion = null;
	int id;
	private JSONArray tree;
	public String list(){
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		id = religionService.save(religion);
	    		religion.setId(id);
	    }else{
	    	religionService.update(religion);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	religion = religionService.get(id);
	return MsgConstants.DISPLAY;
}
public String tree(){
	return MsgConstants.DONE;
}
public String edit(){
	religion = null;
	if(id!=0){
		religion = religionService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	religion = religionService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public ReligionService getReligionService() {
	return religionService;
}
public void setReligionService(ReligionService religionService) {
	this.religionService = religionService;
}
@JSON(serialize=false)
public Religion getReligion() {
	return religion;
}
public void setReligion(Religion religion) {
	this.religion = religion;
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
