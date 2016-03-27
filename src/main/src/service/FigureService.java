package main.src.service;

import java.util.List;

import main.src.entity.gallery.item.Figure;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface FigureService extends BaseService<Figure>{
	public Figure get(String name);
	public List<Figure> getAll(String domain,boolean zhonghua);
	public JSONArray getTree(String domain);
}
