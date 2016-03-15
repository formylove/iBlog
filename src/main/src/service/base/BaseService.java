package main.src.service.base;

public interface BaseService<T> {
	public int save(T obj);
	public void persist(T obj);
	public void delete(int id);
	public void delete(T obj);
	public void update(T obj);
	public T get(int id);
	public void recover(int id);
	public T remove(int id);
}
