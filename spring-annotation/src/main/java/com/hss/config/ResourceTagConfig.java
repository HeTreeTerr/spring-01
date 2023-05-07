package com.hss.config;

import com.hss.dao.BookDao;
import com.hss.dao.impl.BookDaoMysqlImpl;
import com.hss.dao.impl.BookDaoOracleImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.annotation.Resource;

/**
 * @Resource 实现依赖自动注入
 * 	1、java规范（JSR250）的注解
 * 	2、默认按照组件名称进行装配
 * 	3、无法通过required(默认true)属性，可以设置是否一定要注入成功
 * 	4、支持@Primary，指定默认装载
 */
@Configuration
@ComponentScan(
		basePackages={"com.hss.dao"}
		,includeFilters={
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDaoMysqlImpl.class}),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDaoOracleImpl.class}),
}
		,useDefaultFilters = false
)
public class ResourceTagConfig {

	@Resource
	//@Resource(name = "bookDaoOracle")
	private BookDao bookDao;

	public void bookDoSomeThings(){
		bookDao.doSomeThings();
	}
}
