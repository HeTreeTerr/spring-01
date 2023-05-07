package com.hss.tx;

import com.hss.config.TxConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 事务
 */
public class TxTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name:definitionNames){
			System.out.println(name);
		}
	}
}
