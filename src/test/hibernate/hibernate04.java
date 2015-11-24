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
//		n.setAuthor("金圣叹");
//		n.setTitle("金圣叹评水浒");
//		Opus opus = new Opus();
//		opus.setName("水浒传记");
//		n.setOpus(opus);
//		ns.save(n);
//		n = ns.get(1);
//		n.getOpus().setAuthor_directior("施耐庵");;
		Note n = new Note();
		Opus o =new Opus();
		Genre g = new Genre();
		g.setName("志怪小说");
		g.setType("book");
		o.getGenres().add(g);
		n.setOpus(o);
		ns.save(n);
		o.setName("聊斋志异");
		ns.delete(ns.get(5));
//		ns.delete(n);
	}

}
