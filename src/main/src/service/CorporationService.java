package main.src.service;

import java.util.List;

import main.src.entity.gallery.Corporation;
import main.src.entity.gallery.item.Figure;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface CorporationService extends BaseService<Corporation>{
	public Corporation get(String name);
	public JSONArray getTree(String industry);
	public List<Corporation> getAll(String industry,boolean zhonghua);
}
