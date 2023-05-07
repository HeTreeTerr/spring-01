package com.hss.propertySource;

import com.hss.config.PropertySourceTagConfig;
import com.hss.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @PropertySource 基本使用
 */
public class PropertySourceTest {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PropertySourceTagConfig.class);
		//bean 定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for(String name : definitionNames){
			System.out.println(name);
		}

		Person person = ac.getBean(Person.class);
		System.out.println(person);

		//关闭容器
		ac.close();
	}
}
