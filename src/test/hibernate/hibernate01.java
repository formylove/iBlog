package test.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.src.common.Log;
import main.src.entity.Note;
import test.utils.HibernateUtil;

public class hibernate01 {

	public static void main(String[] args) {
//		Session s = HibernateUtil.currentSession(1);
//		Transaction tx = s.beginTransaction();
//		Note n = new Note();
//		n.setAuthor("罗贯中");
//		n.setTitle("三国演义");
//		记录修改		
//		s.save(n);
//		n = (Note) s.load(Note.class,5);
//		n.setAuthor_desc("ming");
//		Log.print("根据主键加载持久化实体", n2.getAuthor());
//		n2 = n;
		//只和对应指向的记录有关，与变量引用无关
//		n2.setAuthor_link("www");
//		s.flush();//作用和commit相同
//		提交修改
//		tx.commit();
//		HibernateUtil.closeSession();
		Session s2 = HibernateUtil.currentSession(1);
		Note n2 = (Note) s2.load(Note.class, 12);
		Transaction tx = s2.beginTransaction();
		n2.setAuthority(222);
		n2.setDel_flag(true);
		s2.update(n2);
//		s2.delete(n2);
		tx.commit();
		
	}

}
