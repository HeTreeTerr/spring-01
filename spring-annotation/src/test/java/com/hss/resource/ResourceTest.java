package com.hss.resource;

import com.hss.config.ResourceTagConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Resource 使用
 */
public class ResourceTest {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ResourceTagConfig.class);
		//输出bean定义
		String[] names = ac.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}
		ResourceTagConfig tagConfig = ac.getBean(ResourceTagConfig.class);
		tagConfig.bookDoSomeThings();
		//关闭容器
		ac.close();
	}
}
