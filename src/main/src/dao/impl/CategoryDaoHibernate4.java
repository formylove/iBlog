package main.src.dao.impl;

import org.springframework.stereotype.Repository;

import main.src.dao.CategoryDao;
import main.src.dao.common.impl.BaseDaoHibernate4;
import main.src.entity.Category;
@Repository("categoryDaoHibernate4")
public class CategoryDaoHibernate4 extends BaseDaoHibernate4<Category> implements CategoryDao 
{	
	public CategoryDaoHibernate4() {
	}

	@Override
	public Category get(int id) {
		return get(Category.class,id);
	}
	//父类有了就不用再写了
}
