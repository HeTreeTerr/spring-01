package com.hss.importTag;

import com.hss.config.ImportTagConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Import 基本使用
 */
public class ImportTest {

	public static void main(String[] args) {
		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportTagConfig.class);
		//获取容器中所有的 bean 定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name: definitionNames) {
			System.out.println(name);
		}

		//关闭容器
		ac.close();
	}
}
