package test.hibernate;

import org.hibernate.Session;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.dao.impl.UserDaoHibernate4;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.entity.User;
import main.src.service.NoteService;
import main.src.service.OpusService;
import main.src.service.UserService;

public class hibernate07 {

	public static void main(String[] args) {
		System.out.println("OOO");
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		UserService us = ctx.getBean("userService",UserService.class);
		OpusService os = ctx.getBean("opusService",OpusService.class);
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		UserDaoHibernate4 ud = ctx.getBean("userDaoHibernate4",UserDaoHibernate4.class);
		Session s = ud.getSession();
		User u = us.get(9);
		Note n = ns.get(3);
		Opus opus = new Opus();
		opus.setId(2);
		//添加关联只需写上Id足够，不进行all级联
		n.setOpus(opus);
		System.out.println("OOxxO");
		ns.update(n);
		System.out.println("OOxxO2");
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
