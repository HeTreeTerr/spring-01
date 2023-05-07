package com.hss.inject;

import com.hss.config.InjectTagConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Inject 使用
 */
public class InjectTest {

	public static void main(String[] args) {
		//容器初始化
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(InjectTagConfig.class);
		//获取bean定义
		String[] definitionNames = ac.getBeanDefinitionNames();
		for(String name:definitionNames){
			System.out.println(name);
		}
		InjectTagConfig injectTagConfig = ac.getBean(InjectTagConfig.class);
		injectTagConfig.bookDoSomeThings();
		//关闭容器
		ac.close();
	}
}
