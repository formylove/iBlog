package main.src.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.MsgConstants;
import net.sf.json.JSONArray;

public class ManagerAction {
String type = null;
JSONArray ja = null;
	public String manage(){
		return MsgConstants.SUCCESS;
	}
	public String load(){
		System.out.println(type);
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		Map<String,String> m = new HashMap<String,String>();
		m.put("title", "一病三年");
		m.put("author", "徐大海");
		data.add(m);
		m.put("title", "丢失");
		m.put("author", "徐大海");
		data.add(m);
        ja = JSONArray.fromObject(data);
		return MsgConstants.DONE;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public JSONArray getJa() {
		return ja;
	}
	public void setJa(JSONArray ja) {
		this.ja = ja;
	}
	
	
}
