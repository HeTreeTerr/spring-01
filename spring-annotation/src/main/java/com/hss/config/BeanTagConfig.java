package com.hss.config;

import com.hss.config.aware.MyApplicationContextUtil;
import com.hss.domain.Car;
import com.hss.postprocessor.MyBeanFactoryPostprocessor;
import com.hss.postprocessor.MyBeanPostprocessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @Bean 向容器中注入 bean
 * 	value/name 指定 beanName
 * 	initMethod 初始化方法
 * 	destroyMethod 销毁方法
 *
 */
@Configuration
@Import(value = {MyBeanPostprocessor.class,MyBeanFactoryPostprocessor.class,MyApplicationContextUtil.class})
public class BeanTagConfig {

	/**
	 * bean 是单例（默认）：
	 * 	容器初始化时执行initMethod，容器关闭时执行destroyMethod
	 * bean 是原型：
	 *	每次从容器中获取bean时执行initMethod，destroyMethod无法执行
	 * @return
	 */
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean(initMethod = "init0",destroyMethod = "destroy0")
	public Car car(){
		return new Car();
	}
}
