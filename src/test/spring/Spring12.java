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

public class Spring12 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws  Exception {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml","C:/Users/Administrator/git/iBlog/src/test/config/beans10.xml"});
		Customer cus = ctx.getBean("cus",Customer.class);
		Address addr1 = cus.returnObj(0);
		Address addr2 = cus.returnObj(0);
		Log.print("first access", addr1);
		Log.print("second access", addr2);
		Log.print("is equal", addr1 == addr2);
		cus.evictCache();
	}

}
