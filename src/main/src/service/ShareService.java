package main.src.service;

import java.util.List;

import main.src.service.base.BaseService;
import net.sf.json.JSONObject;
public interface ShareService extends BaseService<Object>{
	public List<Object> list(String tableName,int maxSize,int pageNum,String order,String conditions);
	public Integer getCnt(String name,String order,String conditions);
	public void delete(String TableName , int id);
	public JSONObject getDatalist(String tableName,int maxSize,int pageNum,String order,String conditions, String properties);
}
