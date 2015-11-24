package main.src.service.base;

import java.io.Serializable;


public interface BaseService<T> {
	public Serializable save(T obj);
	public void persist(T obj);
	public void delete(int id);
	public void delete(T obj);
	public void update(T obj);
	public T get(int id);
	public void recover(int id);
	public void remove(int id);
}
