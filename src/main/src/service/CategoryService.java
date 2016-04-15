package main.src.service;

import java.util.List;

import main.src.entity.Category;
import main.src.service.base.BaseService;

public interface CategoryService extends BaseService<Category>{
	public Category get(String name);
	List<Category> list();
	public void updateOrder(int before,int after);
}
