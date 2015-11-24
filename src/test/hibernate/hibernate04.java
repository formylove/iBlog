package test.hibernate;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.common.Log;
import main.src.entity.Genre;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.service.NoteService;

public class hibernate04 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		NoteService ns = ctx.getBean("noteService",NoteService.class);
//		n.setAuthor("��ʥ̾");
//		n.setTitle("��ʥ̾��ˮ�");
//		Opus opus = new Opus();
//		opus.setName("ˮ䰴���");
//		n.setOpus(opus);
//		ns.save(n);
//		n = ns.get(1);
//		n.getOpus().setAuthor_directior("ʩ����");;
		Note n = new Note();
		Opus o =new Opus();
		Genre g = new Genre();
		g.setName("־��С˵");
		g.setType("book");
		o.getGenres().add(g);
		n.setOpus(o);
		ns.save(n);
		o.setName("��ի־��");
		ns.delete(ns.get(5));
//		ns.delete(n);
	}

}
