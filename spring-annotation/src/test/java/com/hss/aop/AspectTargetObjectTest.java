package com.hss.aop;

import com.hss.config.AopConfig;
import com.hss.customAspect.aspect.AspectTargetObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * aop 切面使用
 */
public class AspectTargetObjectTest {

	public static void main(String[] args) {

		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AopConfig.class);
		//从容器中获取bean
		AspectTargetObject aspectTargetObject = ac.getBean("aspectTargetObject", AspectTargetObject.class);
		aspectTargetObject.operate();

		//关闭容器
		ac.close();
	}
}