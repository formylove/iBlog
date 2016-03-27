package main.src.service;

import java.util.List;

import main.src.entity.Music;
import main.src.service.base.BaseService;
import net.sf.json.JSONArray;

public interface MusicService extends BaseService<Music>{
	public Music get(String name);
	public Music delete(String name);
	public void clear(Integer precedence);
	public JSONArray getTree();
	public List<Music> getZhonghua(boolean zhonghua);
	List<Music> list(int maxSize,int pageNum,String order,String conditions);
}
