package main.src.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.ShareDao;
import main.src.service.ShareService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Service("shareService")
@Transactional
public class ShareServiceImp implements ShareService{
	@Resource(name = "shareDaoHibernate4")
	private ShareDao shareDao;
	@Override
	public int save(Object obj) {
		return 0;
	}
	public List<Object> list(String tableName,int maxSize,int pageNum,String order,String conditions){
		return shareDao.list(tableName, maxSize, pageNum, order, conditions);
	}
	public Integer getCnt(String tableName,String order,String conditions){
		return shareDao.getCnt(tableName, order, conditions);
	}
	@Override
	public void persist(Object obj) {
	}

	@Override
	public void delete(String TableName , int id) {
		Session s = shareDao.getSession();
		String hql = "delete " + TableName +" where id=:id";
		int ID = s.createQuery(hql).setParameter("id", id).executeUpdate();
	}
	@Override
	public void delete(int id) {
	}

	@Override
	public void delete(Object obj) {
	}

	@Override
	public void update(Object obj) {
	}

	@Override
	public Object get(int id) {
		return null;
	}

	@Override
	public void recover(int id) {
	}

	@Override
	public Object remove(int id) {
		return null;
	}
	@Override
	public JSONObject getDatalist(String tableName, int maxSize, int pageNum, String order, String conditions, String properties) {
		List<Object> entities = list(tableName,maxSize,pageNum,order,conditions);
		int cnt = getCnt(tableName,order,conditions);
		if(entities != null && entities.size() != 0 && StringUtils.isNotEmpty(properties)){
		JSONObject datalist = new JSONObject();
		datalist.accumulate("total", cnt);
		JSONArray all = new JSONArray();
		for(Object entity:entities){
			JSONObject obj = new JSONObject();
		for(String property:properties.split(",")){
			String value = null;
			try {
				value = BeanUtils.getProperty(entity, property);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			if(StringUtils.isNotEmpty(value)){
				obj.accumulate(property, value);
			}
		}
		all.add(obj);
		}
		datalist.accumulate("rows", all);
		return datalist;
			
		}else{
			return null;
		}
	}

}
