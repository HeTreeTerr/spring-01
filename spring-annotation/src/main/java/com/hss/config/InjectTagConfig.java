package com.hss.config;

import com.hss.dao.BookDao;
import com.hss.dao.impl.BookDaoMysqlImpl;
import com.hss.dao.impl.BookDaoOracleImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import javax.inject.Inject;

/**
 * @Inject 实现依赖自动注入
 * 1、java规范(JSR330)的注解
 * 2、和@Autowired功能一样，但无法通过required(默认true)属性，可以设置是否一定要注入成功
 * 3、支持@Primary，指定默认装配
 * 4、支持@Qualifier，通过名称去装配
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
public class InjectTagConfig {

	@Qualifier(value="bookDaoOracle")
	@Inject
	private BookDao bookDao;

	public void bookDoSomeThings(){
		bookDao.doSomeThings();
	}
}
