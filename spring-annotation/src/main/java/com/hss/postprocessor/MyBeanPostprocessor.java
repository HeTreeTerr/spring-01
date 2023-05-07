package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
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
