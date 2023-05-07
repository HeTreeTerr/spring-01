package com.hss.circularDependency;

import com.hss.config.CircularDependencyConfig;
import com.hss.service.IndexService;
import com.hss.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 循环依赖注入
 */
public class CircularDependencyTest {

	@Test
	public void circularDependencyTest(){
		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CircularDependencyConfig.class);

		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String definitionName : definitionNames){
			System.out.println(definitionName);
		}

		IndexService indexService = ac.getBean(IndexService.class);
		UserService userService = ac.getBean(UserService.class);

		System.out.println(indexService);
		System.out.println(userService);

		//关闭容器
		ac.close();
	}
}
