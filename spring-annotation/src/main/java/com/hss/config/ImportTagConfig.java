package com.hss.config;

import com.hss.config.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.hss.domain.Worker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * @Import 给容器中注入组件
 */
//@Import(value = {Color.class,Person.class})
//@Import(value = {MyImportSelector.class})
@Import(value = {MyImportBeanDefinitionRegistrar.class})
@ComponentScan(
		basePackages={"com.hss.domain"}
		,includeFilters={
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Worker.class}),
		}
		,useDefaultFilters = false
)
@Configuration
public class ImportTagConfig {

}
