package main.src.service;

import main.src.entity.Category;
import main.src.service.base.BaseService;

public interface CategoryService extends BaseService<Category>{
	public Category get(String name);
}
