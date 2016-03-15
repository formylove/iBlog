package org.crazyit.app.domain;

import java.util.*;

import javax.persistence.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
@Table(name="address_inf")
public class Address
{
	// 标识属性
	@Id @Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	// 定义地址详细信息的成员变量
	private String addressDetail;
	// 定义该Address实体所有关联的Person实体
	@ManyToMany(targetEntity=Person.class)
	// 映射连接表，指定连接表的表名为person_address
	@JoinTable(name="person_address",
		// 映射连接表中名为address_id的外键列，
		// 该列参照当前实体对应表的address_id主键列
		joinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id"),
		// 映射连接表中名为person_id的外键列，
		// 该列参照当前实体对应表的person_id主键列
		inverseJoinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id")
	)
	private Set<Person> persons
		= new HashSet<>();

	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}

	// addressId的setter和getter方法
	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}
	public int getAddressId()
	{
		return this.addressId;
	}

	// addressDetail的setter和getter方法
	public void setAddressDetail(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}
	public String getAddressDetail()
	{
		return this.addressDetail;
	}

	// persons的setter和getter方法
	public void setPersons(Set<Person> persons)
	{
		this.persons = persons;
	}
	public Set<Person> getPersons()
	{
		return this.persons;
	}
}