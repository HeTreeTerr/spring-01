package com.hss.config;

import com.hss.domain.Person;
import com.hss.domain.Worker;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Scope 用来改变bean的生命周期
 * value
 * 	ConfigurableBeanFactory.SCOPE_SINGLETON 单例（默认值） 在容器初始化阶段创建对象
 * 	ConfigurableBeanFactory.SCOPE_PROTOTYPE 原型 在容器初始化成功后，程序获取对象时创建对象
 * 	WebApplicationContext.SCOPE_REQUEST request
 * 	WebApplicationContext.SCOPE_SESSION session
 */
@Configuration
public class ScopeTagConfig {

	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean
	public Worker worker(){
		System.out.println("worker is create");
		return new Worker();
	}

	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Person person(){
		System.out.println("person is create");
		return new Person();
	}
}
