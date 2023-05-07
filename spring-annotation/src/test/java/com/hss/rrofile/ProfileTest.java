package com.hss.rrofile;

import com.hss.config.ProfileTagConfig;
import com.hss.domain.DateSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Profile 使用
 * 	环境激活方法：
 * 		1、vm 参数 -Dspring.profiles.active=test
 * 		2.代码方式（见代码）
 */
public class ProfileTest {

	public static void main(String[] args) {
		//初始化容器
		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileTagConfig.class);

		//初始化容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//激活环境
		ac.getEnvironment().setActiveProfiles("dev");
		//配置文件
		ac.register(ProfileTagConfig.class);
		//刷新容器
		ac.refresh();

		//输出所有 DateSource 类型的 beanName
		String[] namesForType = ac.getBeanNamesForType(DateSource.class);
		for (String name:namesForType){
			System.out.println(name);
		}
		DateSource dateSource = ac.getBean(DateSource.class);
		System.out.println(dateSource);
		//关闭容器
		ac.close();
	}
}
