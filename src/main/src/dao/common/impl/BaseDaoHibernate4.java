package main.src.dao.common.impl;

import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

import main.src.dao.common.BaseDao;
import main.src.entity.Note;

import java.util.List;

import javax.annotation.Resource;

import java.io.Serializable;
public class BaseDaoHibernate4<T> implements BaseDao<T>
{	
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	// DAO������г־û������ײ�������SessionFactory���
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	// ����ע��SessionFactory�����setter����
	// ����ID����ʵ��
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz , Serializable id)
	{
		Session s = sessionFactory.getCurrentSession();
		return (T)s.load(entityClazz , id);
	}
	// ����ʵ��
	public Serializable save(T entity)
	{
		return getSessionFactory().getCurrentSession()
			.save(entity);
	}
	// ����ʵ��
	public void persist(T entity)
	{
	getSessionFactory().getCurrentSession()
				.persist(entity);
	}
	// ����ʵ��
	public void update(T entity)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	// ɾ��ʵ��
	public void delete(T entity)
	{
		getSessionFactory().getCurrentSession().delete(entity);
	}
	// ����IDɾ��ʵ��
	public void delete(Class<T> entityClazz , Serializable id)
	{
		getSessionFactory().getCurrentSession()
			.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter("0" , id)
			.executeUpdate();
	}
	// ��ȡ����ʵ��
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	// ��ȡʵ������

	public long findCount(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// ���ز�ѯ�õ���ʵ������
		if (l != null && l.size() == 1 )
		{
			return (Long)l.get(0);
		}
		return 0;
	}

	// ����HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql)
	{
		return (List<T>)getSessionFactory().getCurrentSession()
			.createQuery(hql)
			.list();
	}
	// ���ݴ�ռλ������HQL����ѯʵ��
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql , Object... params)
	{
		// ������ѯ
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// Ϊ����ռλ����HQL������ò���
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);
		}
		return (List<T>)query.list();
	}
	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,
		 int pageNo, int pageSize)
	{
		// ������ѯ
		return getSessionFactory().getCurrentSession()
			.createQuery(hql)
			// ִ�з�ҳ
			.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.list();
	}
	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param params ���hql��ռλ��������params���ڴ���ռλ������
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql , int pageNo, int pageSize
		, Object... params)
	{
		// ������ѯ
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		// Ϊ����ռλ����HQL������ò���
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);
		}
		// ִ�з�ҳ�������ز�ѯ���
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
