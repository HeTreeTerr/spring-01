package com.hss.aware;

import com.hss.config.AwareConfig;
import com.hss.config.aware.AwareUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Aware 感知器使用
 */
public class AwareTest {

	public static void main(String[] args) {
		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AwareConfig.class);
		//输出bean定义信息
		String[] definitionNames = ac.getBeanDefinitionNames();
		for(String name:definitionNames){
			System.out.println(name);
		}

		AwareUtil awareUtil = ac.getBean(AwareUtil.class);
		System.out.println(awareUtil);
		String resolveStringValue = awareUtil.resolver.resolveStringValue("你好，${os.name}。1+1=#{1+1}");
		System.out.println(resolveStringValue);
		//关闭容器
		ac.close();
	}
}
