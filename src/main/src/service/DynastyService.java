package main.src.service;

import java.util.List;

import main.src.entity.Opus;
import main.src.entity.gallery.Dynasty;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface DynastyService extends BaseService<Dynasty>{
	public Dynasty get(String name);
	public JSONArray getTree();
	public List<Dynasty> getZhonghua(boolean zhonghua);
}
