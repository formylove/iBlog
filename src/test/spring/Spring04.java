package test.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.src.common.Log;
import test.entity.Customer;
import test.entity.Employee;

public class Spring04 {

	@SuppressWarnings({ "resource", "static-access" })
	public static void main(String[] args) {
//ʹ��AbstractApplicationContext 
//�ӿڻ������
AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("test/config/beans04.xml");
Employee employee = ctx.getBean("employee",Employee.class);
Customer cus = ctx.getBean("cus",Customer.class);
//c�������ռ������
Log.print("���� ����", employee.getName());
Log.print("���� ����", employee.getOpus().getName());
//��ȡ����beanfield5
Log.print("���� ��ַ", employee.getAddr().getDetail());
//util:properties
Log.print("util:properties");
cus.getDestinations().list(System.err);
Log.print("hibernate.dialect",cus.getDestinations().getProperty("hibernate.dialect"));
	
	
	
	
	
	
	
	
	}

}
