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
//		Note n0 = ns.get(23);
//		Log.print("get", n0.getAuthor());
//		Note n = new Note();
//		n.setAuthor("曹雪芹");
//		n.setTitle("红楼梦");
//		//save，persist 立即添加到数据库
//		ns.persist(n);
//		已经存入
//		Log.print("id", n.getId());
//		Note n3 = ns.get(6);
//		ns.delete(7);
//		ns.remove(11);
//		Note n0 = ns.get(23);
//		n0.setRead_cnt(n0.getRead_cnt()+1);
//		n0.setFavor_cnt(n0.getFavor_cnt()+1);
//		ns.update(n0);
	}

}
