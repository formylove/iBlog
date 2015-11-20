package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import main.src.common.Log;
import test.entity.Customer;
import test.entity.Employee;
import main.src.entity.Note;
import main.src.service.NoteService;
 
public class Spring02 {

	@SuppressWarnings("resource")
public static void main(String[] args) {
ApplicationContext cxt = new ClassPathXmlApplicationContext("beans02.xml");
NoteService ns = cxt.getBean("noteService",NoteService.class);
Note note = ns.getNote(0);
//嵌套bean
//Log.print("嵌套bean",note.opus.getName());
//集合属性
Log.print("list/bean集合属性",note.comments.get(0).user_name);
Log.print("properties集合属性",note.elses.size());
Log.print("properties集合属性",note.elses.getProperty("climate"));
Log.print("Map集合属性", note.nations.get("cn"));
	
	
	
	
	
	
	
	
	
	
	}

}
