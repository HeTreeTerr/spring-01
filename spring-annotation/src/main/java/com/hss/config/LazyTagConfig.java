package com.hss.config;

import com.hss.domain.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Lazy 单例bean懒加载
 * bean实例化，延后到获取时
 */
@Configuration
public class LazyTagConfig {

	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Lazy
	@Bean
	public Person person(){
		System.out.println("Person is create");
		return new Person();
	}
}
