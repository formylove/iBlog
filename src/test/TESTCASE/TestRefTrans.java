package test.TESTCASE;

import main.src.common.Log;
import main.src.entity.Note;

public class TestRefTrans {

	public static void main(String[] args) {
		Note n = new Note();
		n.setAuthor("helloKitty");
		change(n);
		//引用传递！！！被引用的本身，而非引用
		Log.print("after change", n.getTitle());
		replace(n);
		//引用传递！！！
		Log.print("after replace", n.getAuthor());
		String s = "original";
		changeStr(s);
		Log.print("String after change", s);
		
	}
public static void change(Note note) {
	note.setTitle("nice lady");
}
public static void replace(Note note) {
	Note n = new Note();
	n.setAuthor("dazuihou");
	note = n;
}
public static void changeStr(String s) {
	s = s + "changed";
}
}
