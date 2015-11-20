package test.entity;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import main.src.common.Log;
import main.src.entity.Opus;

public class Employee implements ApplicationContextAware, Person {
	private String name;
	private Address addr;
	private ApplicationContext cxt;
	private Opus opus;  
	private static String MAX_AGE = "27";
	public Employee() {
	}
	public Employee(String name,Opus opus) {
		this.name = name;
		this.opus = opus;
	}
	
	/* (non-Javadoc)
	 * @see main.src.entity.Person#run()
	 */
	@Override
	public void run() {
		Log.print("获取容器",cxt.getMessage("common.login", null, Locale.getDefault())); 
	}
	/* (non-Javadoc)
	 * @see main.src.entity.Person#eat()
	 */
	@Override
	public void eat() {
		Log.print("白领喝", "汤");
	}
	
	public static void sell() {
		Log.print("白领卖", "命");
	}

	@Override
	public void init() {
		Log.print("白领", "created");
		
	}

	@Override
	public void end() {
		Log.print("白领", "destroy");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext cxt) throws BeansException {

		System.out.println();
		this.cxt = cxt;
	}
	
	public static String getMAX_AGE() {
		return MAX_AGE;
	}

	public static void setMAX_AGE(String mAX_AGE) {
		MAX_AGE = mAX_AGE;
	}

	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ApplicationContext getCxt() {
		return cxt;
	}
	public Opus getOpus() {
		return opus;
	}

	public void setOpus(Opus opus) {
		this.opus = opus;
	}

	public void setCxt(ApplicationContext cxt) {
		this.cxt = cxt;
	}
	
}
