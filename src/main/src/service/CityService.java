package main.src.service;

import java.util.List;

import main.src.entity.gallery.City;
import main.src.entity.gallery.State;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface CityService extends BaseService<City>{
	public City get(String name);
	public JSONArray getTree();
	public List<City> getZhonghua();
}
