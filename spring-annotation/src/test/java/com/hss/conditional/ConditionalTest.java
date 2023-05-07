package com.hss.conditional;

import com.hss.config.ConditionalTagConfig;
import com.hss.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @Conditional 注解使用
 */
public class ConditionalTest {

	public static void main(String[] args) {

		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConditionalTagConfig.class);
		Map<String, Person> personMap = ac.getBeansOfType(Person.class);
		System.out.println(personMap);

		//关闭容器
		ac.close();
	}
}
