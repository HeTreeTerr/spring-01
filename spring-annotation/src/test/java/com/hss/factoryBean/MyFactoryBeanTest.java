package com.hss.factoryBean;

import com.hss.config.FactoryBeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * FactoryBean & BeanFactory
 */
public class MyFactoryBeanTest {

	/**
	 * 测试 factoryBean
	 */
	@Test
	public void factoryBean(){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		String[] definitionNames = ac.getBeanDefinitionNames();
		for (String definitionName : definitionNames){
			System.out.println(definitionName);
		}
		//获取 FactoryBean.getObject 生成的对象
		StringBuilder stringBuilder1 = (StringBuilder)ac.getBean("myFactoryBean");
		StringBuilder stringBuilder2 = (StringBuilder)ac.getBean("myFactoryBean");
		System.out.println("工厂bean生成的对象==" + (stringBuilder1 == stringBuilder2));

		//返回 FactoryBean 本身
		MyFactoryBean myFactoryBean = (MyFactoryBean) ac.getBean("&myFactoryBean");
		System.out.println("工厂bean本身" + myFactoryBean);

		//关闭容器
		ac.close();
	}
}