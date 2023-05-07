package com.hss.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 汽车
 */
public class Car implements InitializingBean,DisposableBean {

	private String name;

	public Car() {
		System.out.println("Car constructor is run");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car{" +
				"name='" + name + '\'' +
				'}';
	}

	/**
	 * 初始化方法(@Bean 注解声明)
	 */
	public void init0(){
		System.out.println("Car @Bean is init");
	}

	/**
	 * 销毁方法(@Bean 注解声明)
	 */
	public void destroy0(){
		System.out.println("Car @Bean is destroy");
	}

	/**
	 * 初始化方法（@PostConstruct 声明）
	 */
	@PostConstruct
	public void init1(){
		System.out.println("Car @PostConstruct is run");
	}

	/**
	 * 销毁方法（@PreDestroy 声明）
	 */
	@PreDestroy
	public void destroy1(){
		System.out.println("Car @PreDestroy is run");
	}

	/**
	 * implements InitializingBean
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("car InitializingBean.afterPropertiesSet");
	}

	/**
	 * implements DisposableBean
	 * @throws Exception
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("car DisposableBean.destroy");
	}
}
