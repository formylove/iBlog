package test.spring;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import main.src.common.Log;
import main.src.service.NoteService;
import test.entity.Address;
import test.entity.Customer;

public class Spring11 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws  Exception {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml");
		NoteService ns = ctx.getBean("noteService",NoteService.class);
		ns.get(0);
	}

}
