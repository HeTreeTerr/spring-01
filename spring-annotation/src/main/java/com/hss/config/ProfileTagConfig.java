package com.hss.config;

import com.hss.domain.DateSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Profile 根据环境，选择性注入bean
 * 	1、不设定环境，默认使用 dafault
 *	2、位置： 类（环境激活，类配置生效） 方法（环境激活，方法配置生效）
 */
@Configuration
//@Profile(value="default")
public class ProfileTagConfig {

	@Bean(value = "dateSourceDev")
	//@Profile(value="default")
	@Profile(value="dev")
	public DateSource dateSourceDev(){

		return new DateSource("mysql","127.0.0.1:3306","dev_db");
	}

	@Bean(value = "dateSourceTest")
	@Profile(value="test")
	public DateSource dateSourceTest(){

		return new DateSource("mysql","127.0.0.1:3306","test_db");
	}

	@Bean(value = "dateSourceProd")
	@Profile(value="prod")
	public DateSource dateSourceProd(){

		return new DateSource("mysql","127.0.0.1:3306","prod_db");
	}
}
