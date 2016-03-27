package main.src.service;

import java.util.List;

import main.src.entity.gallery.Nation;
import main.src.entity.gallery.State;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface StateService extends BaseService<State>{
	public State get(String name);
	public JSONArray getTree();
	public List<State> getZhonghua();
}
