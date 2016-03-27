package main.src.service;

import java.util.List;

import main.src.entity.gallery.Nation;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface NationService extends BaseService<Nation>{
	public Nation get(String name);
	public List<Nation> getAll(boolean flag);
	public JSONArray getTree();
	public List<Nation> getZhonghua();
}
