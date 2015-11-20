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
//Ƕ��bean
//Log.print("Ƕ��bean",note.opus.getName());
//��������
Log.print("list/bean��������",note.comments.get(0).user_name);
Log.print("properties��������",note.elses.size());
Log.print("properties��������",note.elses.getProperty("climate"));
Log.print("Map��������", note.nations.get("cn"));
	
	
	
	
	
	
	
	
	
	
	}

}
