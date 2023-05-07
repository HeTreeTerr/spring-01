package com.hss.ioc;

import com.hss.service.IndexService;
import com.hss.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 容器
 */
public class IocTest {

	/**
	 * old
	 * xml配置文件形式，测试ioc
	 */
	@Test
	public void iocXmlTest(){
		//读取xml的方式，初始化spring容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IndexService indexService = ac.getBean(IndexService.class);
		UserService userService = ac.getBean(UserService.class);
		System.out.println(indexService);
		System.out.println(userService);

		ac.close();
	}
}
