package test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.common.Log;
import main.src.dao.impl.UserDaoHibernate4;
import main.src.entity.Note;
import main.src.entity.User;
import main.src.service.UserService;

public class hibernate05 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		UserService us = ctx.getBean("userService",UserService.class);
		UserDaoHibernate4 ud = ctx.getBean("userDaoHibernate4",UserDaoHibernate4.class);
		Session s = ud.getSession();
		String hql ="update User u set device = :device ";
		String hql2 ="from User u where email = ?1 or 1=1";
		String hql3 ="select u.nick_name,u from User u ";
		String hql4 ="from Note";
		String hql5 ="select count(*) from Note ";
		String hql6 ="from User";
		int cnt = s.createQuery(hql).setString("device", "xiaomi 3").executeUpdate();
		List<User> users = (List<User>)s.createQuery(hql2).setParameter("1", "ansyx@163.com").setFirstResult(0).setMaxResults(2).list();
		Log.print("cnt", cnt);
		Log.print("firt user", users.get(1).getNick_name());
		Log.print("user cnt", users.size());
		List<Object[]> cp = (List<Object[]>)s.createQuery(hql3).list();
		List<Note> notes = (List<Note>)s.createQuery(hql4).list();
		Log.print("note's opus-name", notes.get(0).getOpus().getName());
		List<Integer> count = (List<Integer>)s.createQuery(hql5).list();
		Long cntL = (Long)s.createQuery(hql5).uniqueResult();
		Log.print("note's count", count.get(0));
		Log.print("note's count(unique)", cntL);
		Log.print("query string", s.createQuery(hql5).getQueryString());
		User user = (User) s.createCriteria(User.class).add(Restrictions.eq("email", "2@2.c")).setMaxResults(1).uniqueResult();
		Log.print("criteria", user.getNick_name());
		cntL = (Long) s.createCriteria(User.class).setProjection(Projections.projectionList()
				.add(Projections.count("email"))
				).uniqueResult();
		Log.print("projection", cntL);
		Object[] l =  (Object[])s.createCriteria(User.class)
				.setProjection(Projections.projectionList()
				.add(Projections.count("email")).add(Projections.max("id")).add(Projections.avg("id"))
				)
				.uniqueResult();
		Log.print("max_id", l[1]);
		Log.print("avg_id", l[2]);
		int duration = (int)s.createSQLQuery("SELECT TIMESTAMPDIFF(HOUR,register_date,NOW()) duration FROM User WHERE token = :token")
				.addScalar("duration", StandardBasicTypes.INTEGER)
				.setString("token", "0d407b4d-9ca1-45e4-9af7-dcd5f52805fa")
				.setMaxResults(1)
				.uniqueResult();
		Log.print("duration", duration);
		
//		User u = new User();
//		u.setId(1);
//		u.setNick_name("Aurora");
//		u.setEmail("907251709@qq.com");
//		u.setPassword("2222222222");
//		u.setToken(UUID.randomUUID().toString());
//		u.setMotto("free for life");
//		u.setPotrait("http://tp3.sinaimg.cn/2497336742/180/5740840181/0");
//		us.save(u);
	}

}
