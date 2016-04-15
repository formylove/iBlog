package main.src.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

import main.src.dao.CategoryDao;
import main.src.entity.Category;
import main.src.service.CategoryService;
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Resource(name = "categoryDaoHibernate4")
	private CategoryDao categoryDao;
	
	public CategoryServiceImpl() {
	}

	public int save(Category category) {
		if(StringUtils.isNotEmpty(category.getName())){
		Category o = get(category.getName());
		if(o == null){
			return categoryDao.save(category);
		}else{
			return o.getId();
		}
		}else{
			return 0;
		}
	}
	@Override
	public Category get(String name) {
		String hql ="from Category where name=:name";
		Session s = categoryDao.getSession();
		Category category = (Category)s.createQuery(hql).setParameter("name", name).
				setFirstResult(0).setMaxResults(1).uniqueResult();
		return category;
	}

	@Override
	public void persist(Category category) {
		categoryDao.persist(category);
	}
	
	@Override
	public void delete(int id) {
		Category n = get(id); 
		delete(n);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}
	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}
	@Override
	public Category remove(int id) {
		return null;
	}
	@Override
	public List<Category> list() {
		return categoryDao.getSession().createQuery("from Category c Order by order").list();
	}
	@Override
	public void updateOrder(int before,int after) {
		 categoryDao.getSession().createQuery("update Category c set c.order =:after where c.id =:before")
		 .setParameter("after", after)
		 .setParameter("before", before)
		 .executeUpdate();
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public void recover(int id) {
	}

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categorydao) {
		this.categoryDao = categorydao;
	}
	public static List<Category> getAll(){
		ServletContext context =  ServletActionContext.getServletContext(); 
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context); 
		CategoryDao categoryDao = (CategoryDao) ctx.getBean("categoryDaoHibernate4");
		List<Category> cats = categoryDao.findAll(Category.class);
		return cats;
	}



}
