package com.hss.config;

import com.hss.config.condition.LinuxCondition;
import com.hss.config.condition.WindowsCondition;
import com.hss.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Conditional
 * 作用：按照一定的条件判断，满足条件给容器中注册bean
 * 可以在类上 可以在方法上
 */
//@Conditional(value = {WindowsCondition.class})
@Configuration
public class ConditionalTagConfig {

	@Conditional(value = {WindowsCondition.class})
	@Bean(value = "bill")
	public Person person01(){
		return new Person(1L, "Bill Gates");
	}

	@Conditional(value = {LinuxCondition.class})
	@Bean(value = "linus")
	public Person person02(){
		return new Person(2L, "linus");
	}

}
