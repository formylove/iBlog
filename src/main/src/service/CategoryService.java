package main.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.common.SqlUtils;
import main.src.entity.Category;

public class CategoryService {
	static final String TABLE_CATEGORY="category"; 
	public static Category getCategory(int id){
		String sql="select * from category where id="+id;
		@SuppressWarnings("unchecked")
		List<Category> categories =(List<Category>) SqlUtils.executeQuery(sql, null,Category.class);
		if(categories.size()>0){
			return categories.get(0);
		}else{
			return null;
		}
	}
	public static Category getFather(int id){
		return getCategory(getCategory(id).getFather());
	}
	public static String getCategoryName(int id){
		return getCategory(id).getName();
	}
	
	public static int saveCategory(Map<String,Object> data){
		return SqlUtils.executeInsert(data, TABLE_CATEGORY);
	}
	
	public static int deleteCategory(String condition){
		Map<String,Object> flag=new HashMap<String, Object>();
		flag.put("del_flag", 1);
		return updateCategory(flag,condition);
	}
	
	public static int updateCategory(Map<String,Object> data,String condition){
		return SqlUtils.executeUpdate(data, TABLE_CATEGORY, condition);
	}
	
	public static int getLevel(int id){
		return getCategory(id).getLevel();
	}
	public static List<Category> getAllCategories(boolean idValid){
		String sql="select * from category where id<>5000"+(idValid?" and del_flag<>1":"");
		@SuppressWarnings("unchecked")
		List<Category> categories=(List<Category>) SqlUtils.executeQuery(sql, null,Category.class);
		return categories;
	}
	public static void main(String[]args){
		main.src.entity.User user=UserService.getUser(1000);
		CategoryService.getCategoryName(user.getLogin_Cnt());
	}
}

