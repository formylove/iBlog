package test;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.common.Log;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.service.NoteService;

public class Spring01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//ApplicationContext cxt = new FileSystemXmlApplicationContext("C:/Users/Administrator/git/iBlog/src/test/beans.xml");
ApplicationContext cxt = new ClassPathXmlApplicationContext("beans01.xml");
NoteService ns = cxt.getBean("noteService",NoteService.class);
Note note = ns.getNote(0);
Opus opus = cxt.getBean("@xia",Opus.class);
//属性注入
Log.print("属性注入",note.title);
//depend on,而且在构造函数之后注入
Log.print("依赖注入",note.getOpus().getName());
//别名使用
Log.print("别名",opus.name);
//index使用
System.out.println("index:" + opus.original_name);
//自动装配
System.out.println("byName:" + note.comments.get(0).user_name);
System.out.println("大小:" + note.comments.size());
NoteService ns2 = cxt.getBean("noteService",NoteService.class);
//单例模式
Log.print("是否是同一实例", ns == ns2);
//国际化
Log.print("默认语言输出", cxt.getMessage("common.login", null, Locale.getDefault()));
Log.print("英语有参数输出",cxt.getMessage("common.join.date", new Object[]{new Date()}, new Locale("en", "US")));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
