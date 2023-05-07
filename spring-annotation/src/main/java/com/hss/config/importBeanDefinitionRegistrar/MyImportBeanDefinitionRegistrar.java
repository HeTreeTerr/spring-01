package com.hss.config.importBeanDefinitionRegistrar;

import com.hss.domain.Color;
import com.hss.domain.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入 Bean 定义注册器
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 *
	 * @param importingClassMetadata 当前类的注解信息
	 * @param registry Bean 定义注册
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		registry.registerBeanDefinition("person", new RootBeanDefinition(Person.class));
		registry.registerBeanDefinition("color", new RootBeanDefinition(Color.class));
	}
}
