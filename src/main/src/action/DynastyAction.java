package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.gallery.Dynasty;
import main.src.service.DynastyService;
import net.sf.json.JSONArray;

public class DynastyAction {
	@Resource(name="dynastyService")
	private DynastyService dynastyService;
	Dynasty dynasty = null;
	int id;
	private JSONArray tree;
	public String list(){
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		id = dynastyService.save(dynasty);
	    		dynasty.setId(id);
	    }else{
	    	dynastyService.update(dynasty);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	dynasty = dynastyService.get(id);
	return MsgConstants.DISPLAY;
}
public String edit(){
	dynasty = null;
	if(id!=0){
		dynasty = dynastyService.get(id);
	}
	return MsgConstants.SUCCESS;
}
public String tree(){
	tree = dynastyService.getTree();
	return MsgConstants.DONE;
}
public String delete(){
	dynasty = dynastyService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public DynastyService getDynastyService() {
	return dynastyService;
}
public void setDynastyService(DynastyService dynastyService) {
	this.dynastyService = dynastyService;
}
@JSON(serialize=false)
public Dynasty getDynasty() {
	return dynasty;
}
public void setDynasty(Dynasty dynasty) {
	this.dynasty = dynasty;
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
