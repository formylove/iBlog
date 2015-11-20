package test.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.common.Log;
import main.src.entity.Note;
import main.src.service.NoteService;

public class hibernate04 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		Note n = ns.get(3);
		Log.print("�����������س־û�ʵ��", n.getAuthor());
		n = ns.get(3);
		Log.print("�����������س־û�ʵ��", n.getAuthor());
	}

}
