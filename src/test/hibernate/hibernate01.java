package test.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.src.common.Log;
import main.src.entity.Note;
import test.utils.HibernateUtil;

public class hibernate01 {

	public static void main(String[] args) {
		Session s = HibernateUtil.currentSession(1);
		Transaction tx = s.beginTransaction();
		Note n = new Note();
		n.setAuthor("罗贯中");
		n.setTitle("三国演义");
//		记录修改		
		s.save(n);
//		提交修改
		tx.commit();
		Note n2 = (Note) s.load(Note.class, 3);
		Log.print("根据主键加载持久化实体", n2.getAuthor());
		HibernateUtil.closeSession();
	}

}
