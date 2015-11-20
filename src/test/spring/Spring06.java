package test.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import main.src.common.IPParser;
import main.src.common.Log;
import main.src.entity.Opus;
import test.entity.Customer;
import test.entity.Employee;

public class Spring06 {

	@SuppressWarnings({ "resource", "static-access", "rawtypes", "unused" })
	public static void main(String[] args) {
		//使用AbstractApplicationContext 
		AbstractApplicationContext  ctx = new ClassPathXmlApplicationContext("beans6.xml");
		//接口获得容器
//		Employee employee = ctx.getBean("employee",Employee.class);
		Customer cus = ctx.getBean("cus",Customer.class);
}

}
