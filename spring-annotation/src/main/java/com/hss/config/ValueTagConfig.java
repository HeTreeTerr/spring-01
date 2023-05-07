package com.hss.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Value 给 bean 属性赋值
 * 1、基本数值
 * 2、可以写SpEL:#{}
 * 3、可以写${}:取出配置文件中的值（在运行环境变量里面的值）
 */
@Configuration
public class ValueTagConfig {

	@Value(value = "张三")
	private String param1;

	@Value(value = "#{20-2}")
	private Integer param2;

	@Value(value = "${xx.oo:男}")
	private String param3;

	public String getParam1() {
		return param1;
	}

	public Integer getParam2() {
		return param2;
	}

	public String getParam3() {
		return param3;
	}
}
