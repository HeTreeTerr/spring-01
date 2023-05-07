package com.hss.config;

import com.hss.factoryBean.MyFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 工厂bean探究
 */
@Configuration
@Import(value = MyFactoryBean.class)
public class FactoryBeanConfig {
}
