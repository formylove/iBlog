package main.src.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import main.src.common.MsgConstants;
import main.src.entity.gallery.State;
import main.src.service.StateService;
import net.sf.json.JSONArray;

public class StateAction {
	@Resource(name="stateService")
	private StateService stateService;
	private JSONArray tree;
	State state = null;
	int id;
	public String list(){
		return MsgConstants.LIST;
	}
	public String save() throws NumberFormatException, UnsupportedEncodingException{
	    if(id==0){
	    		id = stateService.save(state);
	    		state.setId(id);
	    }else{
	    	stateService.update(state);
	    }
		return MsgConstants.OK;
}
	
public String load(){
	state = stateService.get(id);
	return MsgConstants.DISPLAY;
}
public String tree(){
	tree = stateService.getTree();
	System.out.println("state£º" + tree);
	return MsgConstants.DONE;
}
public String edit(){
	state = null;
	if(id!=0){
		state = stateService.get(id);
	}
	return MsgConstants.SUCCESS;
}

public String delete(){
	state = stateService.remove(id);
	return MsgConstants.DONE;
}
@JSON(serialize=false)
public StateService getStateService() {
	return stateService;
}
public void setStateService(StateService stateService) {
	this.stateService = stateService;
}
@JSON(serialize=false)
public State getState() {
	return state;
}
public void setState(State state) {
	System.out.println("ai?");
	this.state = state;
}
public JSONArray getTree() {
	return tree;
}
public void setTree(JSONArray tree) {
	this.tree = tree;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	
}
