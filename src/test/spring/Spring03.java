package test.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.src.common.Log;
import test.entity.Customer;
import test.entity.Employee;

public class Spring03 {

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
//使用AbstractApplicationContext 
AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans03.xml");
//接口获得容器
Employee employee = ctx.getBean("employee",Employee.class);
employee.run();
//组合属性
Log.print("组合属性", employee.getAddr().getDetail());
//static调用创建bean，父子bean
Employee emp = ctx.getBean("emp",Employee.class);
emp.eat();
Log.print("白领 姓名", emp.getName());
Log.print("白领 地址", emp.getAddr().getDetail());
Customer cus = ctx.getBean("cus",Customer.class);
cus.eat();
Log.print("顾客 姓名", cus.getName());
Log.print("顾客 地址", cus.getAddr().getDetail());
//bean id 获取，addr单例
Log.print("bean id", cus.getAddr().getBeanName());
Log.print("bean id", emp.getAddr().getBeanName());
//depend on
Log.print("bean id", emp.getOpus());
//propertyPath，获取其他bean属性值
Log.print("propertyPath", ctx.getBean("empDetail"));
//获得静态field
Log.print("bean id", emp.getMAX_AGE());
//开闭接口先
//关掉ctx
ctx.registerShutdownHook();
	
	
	
	
	
	
	
	
	
	}

}
