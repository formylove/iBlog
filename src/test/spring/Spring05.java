package test.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import main.src.common.IPParser;
import main.src.common.Log;
import main.src.entity.Opus;
import test.entity.Employee;

public class Spring05 {

	@SuppressWarnings({ "resource", "static-access", "rawtypes" })
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		//运行字符串命令
Expression exp = parser.parseExpression("'hello world'.toUpperCase()");
	Log.print("toUpperCase", exp.getValue());
	Employee emp = new Employee("xiaojianren", new Opus());
//	exp = parser.parseExpression("name");
//	Log.print("name", exp.getValue());
	exp = parser.parseExpression("'Hello World'");
	Log.print("String", exp.getValue(String.class));
//	类型转换
	exp = parser.parseExpression("0.23");
	Log.print("Double", exp.getValue(Double.class));
	//------------使用SpEL创建数组-----------
	// 创建一个数组
	exp = parser.parseExpression("new String[]{'java' , 'Struts' , 'Spring'}");
	Log.print("Obj[] size", ((Object[])exp.getValue()).length);
	
	//------------使用SpEL创建List集合-----------
    exp = parser.parseExpression("{'java' , 'Struts' , 'Spring'}");
    Log.print("list", ((List)exp.getValue()).get(0));
	// 创建“二维”List集合
	exp = parser.parseExpression("{{'疯狂Java讲义' , '疯狂Android讲义'}, {'左传' , '战国策'}}");
	Log.print("list[]", ((List)((List)exp.getValue()).get(1)).get(0));

	//------------使用SpEL访问List集合、Map集合的元素-----------
	List<String> list = new ArrayList<String>();
	list.add("Java web");
	list.add("Spring");
	Map<String, Double> map = new HashMap<String, Double>();
	map.put("Java" , 80.0);
	map.put("Spring" , 89.0);
	//创建一个EvaluationContext对象，作为SpEL解析变量的上下文
	EvaluationContext ctx = new StandardEvaluationContext();
	// 设置两个变量
	ctx.setVariable("mylist" , list);
	ctx.setVariable("mymap" , map);
	// 访问List集合的第二个元素
	Log.print("myList[1]", parser.parseExpression("#mylist[1]").getValue(ctx));
	// 访问Map集合的指定元素
	Log.print("#mymap['Java']", parser.parseExpression("#mymap['Java']").getValue(ctx));

//	------------使用SpEL调用方法-----------
	// 调用String对象的substring()方法
	Log.print("subString", parser.parseExpression("'HelloWorld'.substring(2, 5)").getValue());
	list.add("java");
	
	list.add("struts");
	list.add("spring");
	list.add("hibernate");
	// 设置一个变量
	ctx.setVariable("mylist" , list);
	// 调用指定变量所代表的对象的subList()方法
	Log.print("myList.size", parser.parseExpression("#mylist.subList(4, 5).get(0)").getValue(ctx));

	//------------在SpEL中使用运算符-----------
//	// 对集合的第一个元素进行赋值
	parser.parseExpression("#mylist[0]='疯狂Java讲义'").getValue(ctx);
//	// 下面将输出 疯狂Java讲义
	Log.print("list 赋值", list.get(0));
	// 使用三目运算符
	Log.print("三目运算符", parser.parseExpression("#mylist.size()>3?'myList长度大于3':'myList长度不大于3'").getValue(ctx));

	//------------在SpEL中使用类型运算符-----------
	//类方法调用
	parser.parseExpression("T(test.entity.Employee).sell()").getValue();
	Log.print("test.entity.Employee", parser.parseExpression("T(System).getProperty('os.name')").getValue());

	//------------在SpEL中使用安全导航操作-----------
	// 使用安全操作，将输出null
	Log.print("使用安全操作，将输出null", parser.parseExpression("#emp?.name").getValue());
	//------------在SpEL中使用表达式模板-----------
	Employee p1 = new Employee("孙悟空" ,new Opus());
	Employee p2 = new Employee("猪八戒" ,new Opus());
	Expression expr = parser.parseExpression(
		"我的名字是#{name},寿命是#{MAX_AGE}"
		, new TemplateParserContext());
	// 将使用p1对象name、height填充上面表达式模板中的#{}
	System.out.println(expr.getValue(p1));
	// 将使用p2对象name、height填充上面表达式模板中的#{}
	System.out.println(expr.getValue(p2));
	//------------在SpEL中对集合进行投影-----------
	list.add("疯狂Java讲义");
	list.add("疯狂Ajax讲义");
	list.add("疯狂iOS讲义");
	list.add("经典Java EE企业应用实战");
	ctx.setVariable("mylist" , list);
	// 得到的新集合的元素是原集合的每个元素length()方法返回值
	expr = parser.parseExpression("#mylist.![length()]");
	Log.print("映射函数", expr.getValue(ctx));
	List<Employee> list2 = new ArrayList<Employee>();
	list2.add(new Employee( "孙悟空" , new Opus()));
	list2.add(new Employee( "猪八戒" , new Opus()));
	list2.add(new Employee( "牛魔王" , new Opus()));
	ctx.setVariable("mylist2" , list2);
	// 得到的新集合的元素是原集合的每个元素name属性值
	expr = parser.parseExpression
		("#mylist2.![name]");
	Log.print("映射属性", expr.getValue(ctx));
	//------------省略包名-----------
	Log.print("Math", parser.parseExpression(
			"T(Math).sqrt(9)").getValue());
	//------------在SpEL中调用构造器-----------
	parser.parseExpression(
			"T(javax.swing.JOptionPane).showConfirmDialog(null, '可视化组件调用')").getValue();
}

}
