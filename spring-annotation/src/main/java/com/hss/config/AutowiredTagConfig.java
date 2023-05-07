package com.hss.config;

import com.hss.dao.BookDao;
import com.hss.dao.impl.BookDaoMysqlImpl;
import com.hss.dao.impl.BookDaoOracleImpl;
import com.hss.domain.Address;
import com.hss.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Autowired 实现依赖自动注入
 * 	1、默认按照类型装配
 * 	2、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 * 	3、通过@Qualifier指定装配的实现类
 *	4、通过required(默认true)属性，可以设置是否一定要注入成功
 *  5、通过@Primary，设置基本的注入类
 *  	@Repository(value = "bookDaoMysql")
 * 		@Primary
 * 		public class BookDaoMysqlImpl
 * 	6、标注的位置：属性，方法，参数，构造器
 */
@Configuration
@ComponentScan(
		basePackages={"com.hss.dao","com.hss.domain"}
		,includeFilters={
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDaoMysqlImpl.class}),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDaoOracleImpl.class}),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Student.class,Address.class}),
}
		,useDefaultFilters = false
)
public class AutowiredTagConfig {

	//@Qualifier(value = "bookDaoOracle")
	@Autowired(required = true)
	private BookDao bookDao;

	public void bookDoSomeThings(){
		if(bookDao == null){
			System.out.println("bookDao 没有注入...");
			return;
		}
		bookDao.doSomeThings();
	}

	@Bean(value = "student2")
	public Student student(@Autowired Address address){
		return new Student(address);
	}
}
