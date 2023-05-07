package com.hss.config;

import org.springframework.context.annotation.Configuration;

/**
 * spring 事务
 * 使用步骤：
 * 1）、配置类上使用基于标注的事务管理 @EnableTransactionManagement
 * 2）、配置事务管理器
 *  @Bean
 *  public PlatformTransactionManager transactionManager(DataSource dataSource){
 *  	return new DataSourceTransactionManager(dataSource);
 *  }
 * 3）、在操作数据库的业务方法上标注 @Transactional
 * 测试：
 * 当逻辑方法发生异常时，数据库操作会自动回滚
 *
 * 原理：
 * 1）、@EnableTransactionManagement
 *  利用 TransactionManagementConfigurationSelector 给容器中导入组件
 *  导入两个组件
 *  AutoProxyRegistrar
 *  ProxyTransactionManagementConfiguration
 * 2）、AutoProxyRegistrar作用：
 *  给容器中注册一个 InfrastructureAdvisorAutoProxyCreator 组件；
 *  InfrastructureAdvisorAutoProxyCreator，利用后置处理器机制在对象创建以后，
 *  包装对象，返回一个代理对象（增强器）
 * 3）、ProxyTransactionManagementConfiguration作用：
 *  1）给容器中注册事务增强器 BeanFactoryTransactionAttributeSourceAdvisor
 *  	1、事务增强器要用事务注解的信息 TransactionAttributeSource 解析事务注解
 *  	2、事务拦截器 TransactionInterceptor：保存了事务属性信息，事务管理器
 *  		它是一个MethodInterceptor，在目标方法执行时，执行拦截器链（事务拦截器链）
 *  		事务拦截器invoke()：
 *  		1.先获取事务相关的属性
 *  		2.再获取PlatformTransactionManager，如果实现没有添加指定任何 transactionManager
 *  		 最终会从容器中按类型获取一个PlatformTransactionManager
 *  		3.执行目标方法
 *  		 如果异常，获取到事务管理器，利用事务管理器回滚事务
 *  		 如果正常，利用事务管理器，提交事务
 */
@Configuration
public class TxConfig {

	/**
	 * 此处无代码实现，代码地址如下：
	 * https://github.com/HeTreeTerr/spring-boot/tree/master/spring-boot-jdbc
	 */

}
