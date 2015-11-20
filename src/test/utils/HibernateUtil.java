package test.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import main.src.common.StrUtils;

import org.hibernate.boot.registry.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class HibernateUtil
{
	public static SessionFactory sessionFactory;

	// ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession(int v)
		throws HibernateException
	{	String version = StrUtils.zeroFill(v, 2);
		Configuration cfg = new Configuration()
				.addResource("test/config/hibernate.cfg"+ version + ".xml")
				.configure();
		// 以Configuration实例来创建SessionFactory实例
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session s = session.get();
		// 如果该线程还没有Session,则创建一个新的Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// 将获得的Session变量存储在ThreadLocal变量session里
			session.set(s);
		}
		return s;
	}

	public static void closeSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}