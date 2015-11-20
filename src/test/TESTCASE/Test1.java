package test.TESTCASE;

import main.src.service.NoteService;
import main.src.service.impl.NoteServiceImpl;

public class Test1 {

	public Test1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
NoteService ns = new NoteServiceImpl();
ns.getNote(0);
	}

}
