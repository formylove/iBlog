package test.entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import main.src.common.Log;
@Component
public class Address implements BeanNameAware{
private String detail;
private String beanName;

	public Address() {
	}

	public String getDetail() {
	return detail;
	}

	public void setDetail(String detail) {
	this.detail = detail;
	}

	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}



}
