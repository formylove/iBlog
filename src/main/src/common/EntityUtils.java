package main.src.common;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EntityUtils {
	public static JSONObject getDatalist(List entities,String properties) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		if(entities != null && entities.size() != 0 && StringUtils.isNotEmpty(properties)){
		JSONObject datalist = new JSONObject();
		datalist.accumulate("total", entities.size());
		JSONArray all = new JSONArray();
		for(Object entity:entities){
			JSONObject obj = new JSONObject();
		for(String property:properties.split(",")){
			String value = BeanUtils.getProperty(entity, property);
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
