package com.hss.config;

import com.hss.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

	/**
	 * 通过 @Bean 向容器中注册对象
	 * beanName 默认取方法名，也可以通过 @Bean 标签的value或name属性设置
	 * @return
	 */
	@Bean(value = "personHss")
	public Person personA(){
		return new Person(1L,"hss");
	}

	@Bean(value = "personHpp")
	public Person personB(){
		return new Person(2L,"hpp");
	}
}
