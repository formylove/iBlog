package test.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import main.src.common.Log;
import test.entity.Customer;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public MyBeanPostProcessor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//不需要.class
		if (bean instanceof Customer) {
			((Customer)bean).eat();
		}
		Log.print("对"+beanName, "后增强处理中");
		//必须返回bean，不会获得不到实例，无法新建
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Log.print("对"+beanName, "前增强处理中");
		return bean;
	}

}
