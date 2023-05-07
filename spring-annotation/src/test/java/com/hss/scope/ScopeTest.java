package com.hss.scope;

import com.hss.config.ScopeTagConfig;
import com.hss.domain.Person;
import com.hss.domain.Worker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Scope 标签使用
 */
public class ScopeTest {

	public static void main(String[] args) {
		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScopeTagConfig.class);
		//获取容器中所有的 bean 定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name:
				definitionNames) {
			System.out.println(name);
		}

		Worker worker1 = ac.getBean("worker", Worker.class);
		Worker worker2 = ac.getBean("worker", Worker.class);
		System.out.println("Worker 两次获取对比: " + (worker1 == worker2));

		Person person1 = ac.getBean("person",Person.class);
		Person person2 = ac.getBean("person",Person.class);
		System.out.println("Person 两次获取对比：" + (person1 == person2));

		//关闭容器
		ac.close();
	}
}
