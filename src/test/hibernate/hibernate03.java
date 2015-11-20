package test.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.common.Log;
import main.src.entity.Note;
import main.src.service.NoteService;

public class hibernate03 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		Note n = new Note();
		n.setAuthor("²ÜÑ©ÇÛ");
		n.setTitle("ºìÂ¥ÃÎ");
		//save Á¢¼´Ìí¼Óµ½Êý¾Ý¿â
		int id = (int) ns.save(n);
		Log.print("save id", id);
		ns.persist(n);
	}

}
