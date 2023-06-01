package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 1)BeanFactoryPostProcessor
 * BeanFactory后置处理器
 * 在BeanFactory标准初始化之后调用，所有的bean定义已经被保存加载到beanFactory，但是bean的实例还未创建
 * 支持自定义扩展
 *
 * 源码：
 * 1）、ioc容器创建对象
 * 2）、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessor；
 * 		如何找到所有的BeanFactoryPostProcessor并执行它们的方法
 * 			1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行它们的方法
 * 			2）、在初始化创建其他组件之前执行
 */
@Component
public class MyBeanFactoryPostprocessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("CLASS:MyBeanFactoryPostprocessor,METHOD:postProcessBeanFactory is running...");
	}

}
