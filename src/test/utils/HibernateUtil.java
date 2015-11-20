package test.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import main.src.common.StrUtils;

import org.hibernate.boot.registry.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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

	// ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��
	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession(int v)
		throws HibernateException
	{	String version = StrUtils.zeroFill(v, 2);
		Configuration cfg = new Configuration()
				.addResource("test/config/hibernate.cfg"+ version + ".xml")
				.configure();
		// ��Configurationʵ��������SessionFactoryʵ��
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
		Session s = session.get();
		// ������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null)
		{
			s = sessionFactory.openSession();
			// ����õ�Session�����洢��ThreadLocal����session��
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