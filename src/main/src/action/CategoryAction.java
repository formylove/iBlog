package main.src.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.src.entity.Category;
import main.src.service.CategoryService;

public class CategoryAction {
	List<Category> categories;
	String categoryName;
	int fatherId;
	
	
	public String getCategories(){
		categories=(List<Category>)CategoryService.getAllCategories(true);
		return "editdiary";
	}
	
	public int saveCategory(){
		Map<String,Object> data=new HashMap<String,Object>();
		data.put("name", categoryName);
		data.put("father", fatherId);
		data.put("level", CategoryService.getLevel(fatherId)+1);
		return CategoryService.saveCategory(data);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getFatherId() {
		return fatherId;
	}

	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
