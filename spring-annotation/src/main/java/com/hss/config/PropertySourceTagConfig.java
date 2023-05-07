package com.hss.config;

import com.hss.domain.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource 读取外部配置文件中的K/V保存到运行的环境变量中；
 */
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class PropertySourceTagConfig {

	@Value(value = "${customize.person.id}")
	private Long personId;

	@Value(value = "${customize.person.name}")
	private String personName;

	@Bean
	public Person person(){
		return new Person(personId, personName);
	}
}
