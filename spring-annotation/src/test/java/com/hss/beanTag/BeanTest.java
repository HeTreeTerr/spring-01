package com.hss.beanTag;

import com.hss.config.BeanTagConfig;
import com.hss.config.aware.MyApplicationContextUtil;
import com.hss.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Bean 使用
 */
public class BeanTest {

	public static void main(String[] args) {

		//初始化spring容器
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanTagConfig.class);
		//获取容器中所有的 bean 定义信息
		/*String[] definitionNames = ac.getBeanDefinitionNames();
		for (String name:
				definitionNames) {
			System.out.println(name);
		}*/

		Car car = ac.getBean(Car.class);
		System.out.println(car);

		MyApplicationContextUtil contextUtil = ac.getBean(MyApplicationContextUtil.class);
		System.out.println(contextUtil.getApplicationContext());
		//关闭容器
		ac.close();
	}
}
