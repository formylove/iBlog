package test.entity;

import java.util.Locale;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import main.src.common.Log;

public class Customer implements ApplicationContextAware, Person,InitializingBean,DisposableBean {
	private String name;
	@Autowired
	private Address addr;
	private  Employee emps;
	@Resource(name = "gf")
	private GirlFiriend gf;
	private Properties destinations;
	private ApplicationContext cxt;
	public Customer() {
	}
	@CacheEvict(value = "sample")
	public Address evictCache() {
		return new Address();
	}
	@Cacheable(value = "sample")
	public Address returnObj(int i) {
		return new Address();
	}
	
	@Override
	public void destroy() throws Exception {
		Log.print("顾客接口", "destroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Log.print("顾客接口", "created");
	}
	
	@Override
	public void run() {
		Log.print("获取容器",cxt.getMessage("common.login", null, Locale.getDefault())); 
	}
	@Override
	public void eat() {
		Log.print("顾客吃", "肉");
	}

	@Override
	public void init() {
		Log.print("顾客", "created");
	}

	@Override
	public void end() {
		Log.print("顾客", "destroy");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext cxt) throws BeansException {

		System.out.println();
		this.cxt = cxt;
	}
	 
	public GirlFiriend getGf() {
		return gf;
	}
	public void setGf(GirlFiriend gf) {
		this.gf = gf;
	}
	public Properties getDestinations() {
		return destinations;
	}

	public void setDestinations(Properties destinations) {
		this.destinations = destinations;
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
	public void setCxt(ApplicationContext cxt) {
		this.cxt = cxt;
	}
}
