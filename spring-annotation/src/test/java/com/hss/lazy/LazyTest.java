package com.hss.lazy;

import com.hss.config.LazyTagConfig;
import com.hss.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Lazy 标签使用
 */
public class LazyTest {

	public static void main(String[] args) {

		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LazyTagConfig.class);
		//获取容器中所有的 bean 定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name:
				definitionNames) {
			System.out.println(name);
		}

		Person person = ac.getBean("person",Person.class);

		//关闭容器
		ac.close();
	}
}
