package com.hss.config;

import com.hss.config.typeFilter.MyTypeFilter;
import com.hss.controller.HelloController;
import com.hss.customAnnotation.anntation.LogAnnotation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @ComponentScan 属性介绍
 * value 和 basePackages 等价，用于指定要扫描哪些包
 * includeFilters 包含
 * 	FilterType.ANNOTATION 按注解
 * 	FilterType.ASSIGNABLE_TYPE 按给定类型
 * 	FilterType.ASPECTJ 使用ASPECTJ表达式
 * 	FilterType.REGEX 使用正则
 * 	FilterType.CUSTOM 使用自定义规则
 *
 * excludeFilters 排除
 * useDefaultFilters 禁用默认过滤规则
 *
 * 如果是jdk1.8,@ComponentScan可以重复标注
 * 如果不是，可以使用@ComponentScans实现重复标注
 */
/*@ComponentScan(
		basePackages={"com.hss.domain", "com.hss.service"}
		,includeFilters={
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {HelloController.class}),
				@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {LogAnnotation.class}),
		}
		,excludeFilters={@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Person.class})}
		,useDefaultFilters = false
		)
@ComponentScan(basePackages={"com.hss.controller"})*/
@ComponentScans(value = {
		@ComponentScan(
				basePackages={"com.hss.domain", "com.hss.service"}
				,includeFilters={
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {HelloController.class}),
				@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {LogAnnotation.class}),
				@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}),
		}
//				,excludeFilters={@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Person.class})}
				,useDefaultFilters = false
		)
		,@ComponentScan(basePackages={"com.hss.controller"})
})
@Configuration
public class ComponentScanTagConfig {

}
