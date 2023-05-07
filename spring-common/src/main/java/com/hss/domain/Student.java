package com.hss.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 学生
 */
@Component(value = "student1")
public class Student {

	private String name;

	/**
	 * 属性注入
	 */
	//@Autowired
	private Address address;

	public Student() {
	}


	/**
	 * 构造器注入
	 * @param address
	 */
	@Autowired
	public Student(Address address) {
		this.address = address;
	}

	public Student(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	/**
	 * 方法注入
	 * @param address
	 */
	//@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", address=" + address +
				'}';
	}
}
