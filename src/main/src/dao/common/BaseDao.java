package main.src.dao.common;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T>
{
	// 根据ID加载实体
	T get(Class<T> entityClazz , int id);
	// 保存实体
	int save(T entity);
	// 持久化实体
	void persist(T entity);
	// 更新实体
	void update(T entity);
	// 删除实体
	void delete(T entity);
	// 获得session
	Session getSession();
	// 根据ID删除实体
	void delete(Class<T> entityClazz , int id);
	// 获取所有实体
	List<T> findAll(Class<T> entityClazz);
	// 获取实体总数
	long findCount(Class<T> entityClazz);
}
