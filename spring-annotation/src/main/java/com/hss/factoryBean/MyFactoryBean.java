package com.hss.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean<StringBuilder> {

	@Override
	public StringBuilder getObject() throws Exception {
		return new StringBuilder("jojo");
	}

	@Override
	public Class<StringBuilder> getObjectType() {
		return StringBuilder.class;
	}

	/**
	 * 创建出来的bean是否是单例
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}
}
