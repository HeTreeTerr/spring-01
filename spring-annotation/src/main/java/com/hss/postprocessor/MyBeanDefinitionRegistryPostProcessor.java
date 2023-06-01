package com.hss.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 1)BeanDefinitionRegistryPostProcessor
 * 继承了BeanFactoryPostProcessor
 * 在BeanDefinition将要被完成，但还没有实例化bean时触发
 * 在BeanFactoryPostProcessor.postProcessBeanFactory之前执行
 * 实现对BeanDefinition的增删改查
 *
 * 源码：
 * 1）、ioc容器创建对象
 * 2）、invokeBeanFactoryPostProcessors(beanFactory);执行BeanDefinitionRegistryPostProcessor;
 * 3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件
 * 		1、依次触发所有的postProcessBeanDefinitionRegistry()方法
 * 		2、再来触发postProcessBeanFactory()方法
 * 4）、再来从容器中找到	BeanFactoryPostProcessor组件，然后依次执行postProcessBeanFactory()方法
 * </p>
 *
 * @author Hss
 * @date 2023-06-01
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        System.out.println("CLASS:MyBeanDefinitionRegistryPostProcessor,METHOD:postProcessBeanFactory is running...");
    }

    /**
     * BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个
     * bean定义信息创建bean实例
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //增加bean定义
        BeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClassName("com.hss.domain.Address");
        registry.registerBeanDefinition("address",bd);
        System.out.println("CLASS:MyBeanDefinitionRegistryPostProcessor,METHOD:postProcessBeanDefinitionRegistry is running...");
    }
}
