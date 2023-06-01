package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 1)BeanFactoryPostProcessor
 * BeanFactory后置处理器
 * bean 工厂初始化完成后调用
 * 支持自定义扩展
 *
 * 2)BeanDefinitionRegistryPostProcessor
 * 继承了BeanFactoryPostProcessor
 * 在BeanDefinition加载完成，但还没有实例化bean时触发
 * 在BeanFactoryPostProcessor.postProcessBeanFactory之前执行
 * 实现对BeanDefinition的增删改查
 */
@Component
public class MyBeanFactoryPostprocessor implements BeanFactoryPostProcessor,BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

//		GenericBeanDefinition indexService = (GenericBeanDefinition)beanFactory.getBeanDefinition("indexService");
//		indexService.setBeanClass(UserService.class);
		System.out.println("CLASS:HssBeanFactoryPostprocessor,METHOD:postProcessBeanFactory is running...");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//增加bean定义
		BeanDefinition bd = new GenericBeanDefinition();
		bd.setBeanClassName("com.hss.domain.Address");
		registry.registerBeanDefinition("address",bd);
		System.out.println("CLASS:HssBeanFactoryPostprocessor,METHOD:postProcessBeanDefinitionRegistry is running...");
	}
}
