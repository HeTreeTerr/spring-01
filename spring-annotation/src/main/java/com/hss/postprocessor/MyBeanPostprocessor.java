package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor:
 * bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *
 * postProcessBeforeInitialization
 * postProcessAfterInitialization
 * 分别在执行初始化方法前后执行
 */
public class MyBeanPostprocessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("MyBeanPostprocessor.postProcessBeforeInitialization beanName:" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("MyBeanPostprocessor.postProcessAfterInitialization beanName:" + beanName);
		return bean;
	}
}
