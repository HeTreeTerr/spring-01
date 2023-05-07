package com.hss.autowired;

import com.hss.config.AutowiredTagConfig;
import com.hss.domain.Address;
import com.hss.domain.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Autowired 基本使用
 */
public class AutowiredTest {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowiredTagConfig.class);
		//输出bean定义
		String[] definitionNames = ac.getBeanDefinitionNames();
		for(String name:definitionNames){
			System.out.println(name);
		}

		AutowiredTagConfig autowiredTagConfig = ac.getBean(AutowiredTagConfig.class);
		autowiredTagConfig.bookDoSomeThings();

		Student student1 = ac.getBean("student1", Student.class);
		Student student2 = ac.getBean("student2", Student.class);
		Address address = ac.getBean(Address.class);
		System.out.println(student1 == student2);
		System.out.println(address);

		//关闭容器
		ac.close();
	}
}
