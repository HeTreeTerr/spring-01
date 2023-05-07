package com.hss.ioc;

import com.hss.config.MainConfig;
import com.hss.domain.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC 容器
 */
public class IocTest {

	/**
	 * new
	 * 注解形式，测试ioc
	 */
	@Test
	public void iocAnnotationTest(){
		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);

		/*
		//设置spring 不支持循环依赖
		ac.setAllowCircularReferences(false);
		//刷新容器，使配置生效
		ac.refresh();
		*/

		//从容器中获取对象
		Person person = ac.getBean("personHss", Person.class);
		System.out.println(person);

		//获取容器中 Person.class 类型的 bean
		String[] namesForType = ac.getBeanNamesForType(Person.class);
		for (String name:
			 namesForType) {
			System.out.println(name);
		}
		ac.close();
	}

}
