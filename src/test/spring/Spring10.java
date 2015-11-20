package test.spring;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

import main.src.common.Log;
import test.entity.Address;
import test.entity.Customer;

public class Spring10 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws  Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("test/config/beans10.xml");
		Customer cus = ctx.getBean("cus",Customer.class);
		Log.print("addr-autowired", cus.getAddr());
		Log.print("gf-resource", cus.getGf());
	}

}
