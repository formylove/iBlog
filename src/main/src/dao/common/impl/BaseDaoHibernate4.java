package main.src.dao.common.impl;

import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.common.BaseDao;
import main.src.entity.Music;
import main.src.entity.Note;

import java.util.List;

import javax.annotation.Resource;

@Repository("baseDaoHibernate4")
public class BaseDaoHibernate4<T> implements BaseDao<T>
{	
	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;
	public BaseDaoHibernate4() {
	}
	// 依赖注入SessionFactory所需的setter方法
	// 根据ID加载实体
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz , int id)
	{
		Session s = sessionFactory.getCurrentSession();
		//load返回一个镜像，不加载数据
		T rvt = (T)s.get(entityClazz , id);
		return  rvt;
	}
	// 保存实体
	public int save(T entity)
	{
//		getSessionFactory().getCurrentSession().refresh(entity);
		int cnt = (int) getSessionFactory().getCurrentSession()
			.save(entity);
		return cnt;
	}
	// 保存实体
	public void persist(T entity)
	{
	getSessionFactory().getCurrentSession()
				.persist(entity);
	}
	// 更新实体
	public void update(T entity)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	// 删除实体
	public void delete(T entity)
	{
		getSessionFactory().getCurrentSession().delete(entity);
//		事务管理不需要flush
//		s.flush();
	}
	@Override
	public Session getSession()
	{  
		Session s = sessionFactory.openSession();
		return s;
	}
	// 根据ID删除实体
	public void delete(Class<T> entityClazz , int id)
	{
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter("0" , id)
			.executeUpdate();
	}
	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("from "+ entityClazz.getSimpleName() + " en");
	}
	// 根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql)
	{
		Session s = getSession();
		return (List<T>)s
			.createQuery(hql)
			.list();
	}
	// 获取实体总数
	public long findCount(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1 )
		{
			return (Long)l.get(0);
		}
		return 0;
	}


	// 根据带占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql , Object... params)
	{
		// 创建查询
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);
		}
		return (List<T>)query.list();
	}
		// 创建查询
		public List<T> list(String name,int maxSize,int pageNum,String order,String conditions){
			String hql = "from " + name + (conditions!=null?" where "+conditions:" ") + (order!=null?" order by " + order:"");
			Session s = getSession();
			List<T> objs = s.createQuery(hql).setMaxResults(maxSize).setFirstResult((pageNum-1)*maxSize).list();
			return objs;
			}
		public Integer getCnt(String name,String order,String conditions){
			String hql = "select count(*) from " + name + (conditions!=null?" where "+conditions:" ") + (order!=null?" order by ":"") + order;
			Session s = getSession();
			Integer cnt = Integer.parseInt(((Long)s.createQuery(hql).uniqueResult()).toString());
			return cnt;
		}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByPage(String hql,int pageNo, int pageSize)
	{
		// 创建查询
		return getSessionFactory().getCurrentSession()
			.createQuery(hql)
			// 执行分页
			.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.list();
	}
	/**
	 * 使用hql 语句进行分页查询操作
	 * @param hql 需要查询的hql语句
	 * @param params 如果hql带占位符参数，params用于传入占位符参数
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql , int pageNo, int pageSize
		, Object... params)
	{
		// 创建查询
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.list();
	}
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}
}
