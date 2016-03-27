package main.src.service;

import java.util.List;

import main.src.entity.Opus;
import main.src.entity.gallery.City;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface OpusService extends BaseService<Opus>{
	public boolean hasExisted(String name);
	public Opus get(String name);
	public JSONArray getTree();
	public JSONArray getTree(String type);
	public List<Opus> getZhonghua(String type);
}
