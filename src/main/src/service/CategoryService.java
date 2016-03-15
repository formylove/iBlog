package main.src.service;

import java.util.List;

import main.src.entity.Category;
import main.src.service.base.BaseService;

public interface CategoryService extends BaseService<Category>{
	public List<Category> getAll();
}
