package main.src.dao.common;

import java.util.List;
import java.io.Serializable;

public interface BaseDao<T>
{
	// ����ID����ʵ��
	T get(Class<T> entityClazz , Serializable id);
	// ����ʵ��
	Serializable save(T entity);
	// �־û�ʵ��
	void persist(T entity);
	// ����ʵ��
	void update(T entity);
	// ɾ��ʵ��
	void delete(T entity);
	// ����IDɾ��ʵ��
	void delete(Class<T> entityClazz , Serializable id);
	// ��ȡ����ʵ��
	List<T> findAll(Class<T> entityClazz);
	// ��ȡʵ������
	long findCount(Class<T> entityClazz);
}
