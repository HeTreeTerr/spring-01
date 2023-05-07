package com.hss.componentScan;

import com.hss.config.ComponentScanTagConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ComponentScan
 * @ComponentScans
 * 注解使用测试
 */
public class ComponentScanTest {

	public static void main(String[] args) {

		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanTagConfig.class);
		//获取容器中所有的 bean 定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name:
			 definitionNames) {
			System.out.println(name);
		}

		//关闭容器
		ac.close();
	}
}
