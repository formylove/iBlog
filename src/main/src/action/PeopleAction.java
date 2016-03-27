package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.gallery.People;
import main.src.service.PeopleService;
import net.sf.json.JSONArray;

public class PeopleAction {
	@Resource(name="peopleService")
	private PeopleService peopleService;
	People people = null;
	int id;
	private JSONArray tree;
	public String list(){
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		id = peopleService.save(people);
	    		people.setId(id);
	    }else{
	    	peopleService.update(people);
	    }
		return MsgConstants.DISPLAY;
}
	
public String load(){
	people = peopleService.get(id);
	return MsgConstants.DISPLAY;
}
public String tree(){
	return MsgConstants.DONE;
}
public String edit(){
	people = null;
	if(id!=0){
		people = peopleService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	people = peopleService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public PeopleService getPeopleService() {
	return peopleService;
}
public void setPeopleService(PeopleService peopleService) {
	this.peopleService = peopleService;
}
@JSON(serialize=false)
public People getPeople() {
	return people;
}
public void setPeople(People people) {
	this.people = people;
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
