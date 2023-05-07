package com.hss.value;

import com.hss.config.ValueTagConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Value 使用
 */
public class ValueTest {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ValueTagConfig.class);
		//获取 bean 定义
		String[] definitionNames = ac.getBeanDefinitionNames();
		for(String name:definitionNames){
			System.out.println(name);
		}
		ValueTagConfig valueTagConfig = ac.getBean(ValueTagConfig.class);
		System.out.println("ValueTagConfig.param1:" + valueTagConfig.getParam1());
		System.out.println("ValueTagConfig.param2:" + valueTagConfig.getParam2());
		System.out.println("ValueTagConfig.param3:" + valueTagConfig.getParam3());
		//关闭容器
		ac.close();
	}
}
