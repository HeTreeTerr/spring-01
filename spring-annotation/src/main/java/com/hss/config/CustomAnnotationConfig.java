package com.hss.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 自定义注解
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.hss.customAnnotation")
public class CustomAnnotationConfig {
}
