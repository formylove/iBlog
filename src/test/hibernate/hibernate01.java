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
		n.setAuthor("�޹���");
		n.setTitle("��������");
//		��¼�޸�		
		s.save(n);
//		�ύ�޸�
		tx.commit();
		Note n2 = (Note) s.load(Note.class, 3);
		Log.print("�����������س־û�ʵ��", n2.getAuthor());
		HibernateUtil.closeSession();
	}

}
