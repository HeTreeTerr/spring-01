package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactory后置处理器
 * bean 工厂初始化完成后调用
 * 支持自定义扩展
 */
@Component
public class MyBeanFactoryPostprocessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

//		GenericBeanDefinition indexService = (GenericBeanDefinition)beanFactory.getBeanDefinition("indexService");
//		indexService.setBeanClass(UserService.class);
		System.out.println("CLASS:HssBeanFactoryPostprocessor,METHOD:postProcessBeanFactory is running...");
	}
}
