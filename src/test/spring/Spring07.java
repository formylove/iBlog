package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import main.src.common.IPParser;
import main.src.common.Log;
import main.src.entity.Note;
import main.src.entity.Opus;
import main.src.service.NoteService;
import main.src.service.impl.NoteServiceImpl;
import test.entity.Customer;
import test.entity.Employee;

public class Spring07 {

	@SuppressWarnings({ "resource", "static-access", "rawtypes", "unused" })
	public static void main(String[] args) {
		AbstractApplicationContext  ctx = new FileSystemXmlApplicationContext("C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml");
		NoteService ns = ctx.getBean("noteService" ,NoteServiceImpl.class);
		Note note = ns.get(0);
		Log.print("note name", note.getCreate_date());
}

}
