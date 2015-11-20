package test.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.src.common.Log;
import test.entity.Customer;
import test.entity.Employee;

public class Spring04 {

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
//使用AbstractApplicationContext 
//接口获得容器
AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("test/config/beans04.xml");
Employee employee = ctx.getBean("employee",Employee.class);
Customer cus = ctx.getBean("cus",Customer.class);
//c：命名空间简化配置
Log.print("白领 姓名", employee.getName());
Log.print("白领 姓名", employee.getOpus().getName());
//获取其他beanfield5
Log.print("白领 地址", employee.getAddr().getDetail());
//util:properties
Log.print("util:properties");
cus.getDestinations().list(System.err);
Log.print("hibernate.dialect",cus.getDestinations().getProperty("hibernate.dialect"));
	
	
	
	
	
	
	
	
	}

}
