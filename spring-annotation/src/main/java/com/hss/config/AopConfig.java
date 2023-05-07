package com.hss.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop 使用:[动态代理]
 * 	指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 *
 * 	源码分析：
 * 	@EnableAspectJAutoProxy 作用：启动切面自动代理
 * 	 @Import(AspectJAutoProxyRegistrar.class)
 * 	  AspectJAutoProxyRegistrar.registerBeanDefinitions
 * 	   AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
 * 	    return registerOrEscalateApcAsRequired(AnnotationAwareAspectJAutoProxyCreator.class, registry, source);
 * 	    向 BeanDefinitionRegistry 中注册了AnnotationAwareAspectJAutoProxyCreator.class
 *
 * AnnotationAwareAspectJAutoProxyCreator作用：
 * 	向上找实现接口，锁定 AbstractAutoProxyCreator --> implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 * 	 AbstractAdvisorAutoProxyCreator.setBeanFactory()
 * 	  AbstractAdvisorAutoProxyCreator.initBeanFactory
 * 	 AbstractAutoProxyCreator.有后置处理器逻辑；
 *
 * 流程：
 * 	1）、传入配置类，创建ioc容器
 * 	2）、注册配置类，调用refresh()刷新容器；
 * 	3）、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 * 	 1、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *   2、给容器中加别的BeanPostProcessor（BeanPostProcessorChecker.class）
 *   3、优先注册implement PriorityOrdered接口的BeanPostProcessor
 *   4、再给容器中注册implement Ordered接口的BeanPostProcessor
 *   5、注册没实现优先级接口的BeanPostProcessor
 *   6、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，并保存在容器中
 *   	创建internalAutoProxyCreator的BeanPostProcessor[AnnotationAwareAspectJAutoProxyCreator]
 *   	 1)创建Bean实例
 *   	 2)populateBean(beanName, mbd, instanceWrapper);给bean的各种属性赋值
 *   	 3)initializeBean(beanName, exposedObject, mbd);初始化bean:
 *   	 	1.invokeAwareMethods();处理Aware接口方法回调
 *   	 	2.applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);应用后置处理器的postProcessBeforeInitialization()
 *   	 	3.invokeInitMethods();执行自定义的初始化方法
 *   	 	4.applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);应用后置处理器的postProcessAfterInitialization()
 *   	 4)BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功
 *   7、beanFactory.addBeanPostProcessor(postProcessor);把BeanPostProcessor注册到beanFactory中
 * ========以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程===========
 * AnnotationAwareAspectJAutoProxyCreator =>SmartInstantiationAwareBeanPostProcessor =>InstantiationAwareBeanPostProcessor
 *  ==AbstractAutoProxyCreator.postProcessBeforeInstantiation()
 *  ==AbstractAutoProxyCreator.postProcessAfterInstantiation()
 *  4）、finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作，创建剩下的单实例Bean
 *   1、遍历获取容器中所有的Bean，依次创建对象getBean(beanName);
 *   	getBean -> doGetBean -> getSingleton
 *   2、创建bean
 *   	[BeanPostProcessor是Bean对象创建完成初始化前后调用的]
 *   	[InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的]
 *   	1)先从缓存中获取当前bean，如果能获取到，说明之前bean是被创建过的，直接使用，否则再创建
 *   		只要创建好的Bean都会被缓存起来
 *   	2)createBean();创建bean
 *   		1.resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation
 *   	 	 希望后置处理器在此能创建一个代理对象，如果能返回代理对象就使用，如果不能就继续创建
 *   	 	 1）后置处理器先尝试返回对象 AnnotationAwareAspectJAutoProxyCreator会在任何Bean创建之前先尝试返回bean的实例
 *   	 	2.doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例
 *   3、结论：
 *   AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，
 *   会调用InstantiationAwareBeanPostProcessor接口的postProcessBeforeInstantiation()
 * ========AnnotationAwareAspectJAutoProxyCreator.postProcessBeforeInstantiation========
 *  1）、每一个bean创建之前，调用postProcessBeforeInstantiation()；
 *   关心目标类（MyAspect）和切面类（AspectTargetObject）的创建
 *   1、判断当前bean是否在advisedBeans中（保留了所有需要增强的bean）
 *   2、判断当前bean是否是基础类型的Advice、Pointcut、Advisor、AopInfrastructureBean
 *   	或者是否是切面（@Aspect）
 *   3、是否需要跳过
 *   	1)获取候选的增强器（切面里的通知方法）[List<Advisor> candidateAdvisors]
 *   		每一个封装的通知方法的增强器InstantiationModelAwarePointcutAdvisor
 *   		判断每一个增强器是否是AspectJPointcutAdvisor类型的，返回true，否则返回false
 *  2）、创建对象，调用postProcessAfterInitialization();
 * 	return wrapIfNecessary(bean, beanName, cacheKey);包装如果需要的情况
 * 	 1、获取当前bean的所有增强器（通知方法） [Object[] specificInterceptors]
 *    	1)找到候选的所有增强器（找那些通知方法是需要切入当前bean方法的）
 *   	2)获取能在bean使用的增强器
 *   	3)给增强器排序
 *   2、保存当前bean在advisedBeans中；
 *   3、如果当前bean需要增强，创建当前bean的代理对象；
 *   	1)获取所有增强器（通知方法）
 *   	2)保存到proxyFactory
 *   	3)创建代理对象：Spring自动决定 org.springframework.aop.framework.AopProxyFactory
 *   		JdkDynamicAopProxy(config);jdk动态代理
 *   		ObjenesisCglibAopProxy(config);Cglib动态代理
 *   4、给容器中返回当前组件使用cglib增强了的代理对象；
 *   5、以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程；
 *  3）、目标方法执行
 *   容器中保存了组件的代理对象（cglib增强后的对象），这个对象里面保存了详细信息（比如增强器，目标对象...）
 *   1、CglibAopProxy.intercept();拦截目标方法的执行
 *   2、根据ProxyFactory对象，获取将要执行方法的拦截器链
 *   	List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
 *		1)List<Object> interceptorList保存所有拦截器 6
 *			一个默认ExposeInvocationInterceptor和5个增强器
 *		2)遍历所有的增强器，将其转换为Interceptor；
 *			registry.getInterceptors(advisor);
 *		3)将增强器转为List<MethodInterceptor>;
 *			如果是MethodInterceptor，直接加入到集合中
 *			如果不是，使用	AdvisorAdapter将增强器转为MethodInterceptor
 *			转换完成返回MethodInterceptor数组
 *   3、如果没有拦截器链，直接执行目标方法
 *   	拦截器链（每一个通知方法又被包装为方法拦截器，利用MethodInterceptor机制）
 *   4、如果有拦截器链，把需要执行的目标对象，目标方法，拦截器链等信息传入并创建一个CglibMethodInvocation对象，
 *   	并调用.proceed()
 *   5、拦截器链的触发过程
 *   	1)如果没有拦截器执行目标方法，或者拦截器的索引和拦截器数组-1大小一样（指到了最后一个拦截器）执行目标方法；
 *   	2)链式获取每一个拦截器，拦截器执行invoke方法，每一个拦截器等待下一个拦截器执行完撑返回以后再来执行；
 *   		拦截器链的机制，保证通知方法与目标方法的执行顺序
 *
 * 总结：
 *  1）、@EnableAspectJAutoProxy 启动切面自动代理
 *  2）、@EnableAspectJAutoProxy 会给容器中注册一个组件 AnnotationAwareAspectJAutoProxyCreator
 *  3）、AnnotationAwareAspectJAutoProxyCreator 是一个后置处理器
 *  4）、容器的创建流程
 *   1、registerBeanPostProcessors() 注册后置处理器；创建 AnnotationAwareAspectJAutoProxyCreator 对象
 *   2、finishBeanFactoryInitialization() 初始化剩下的单实例bean
 *   	1)创建业务逻辑组件和切面组件
 *   	2)AnnotationAwareAspectJAutoProxyCreator 拦截组件的创建过程
 *   	3)组件创建完之后，判断组件是否需要增强
 *   		是：切面的通知方法，包装成增强器(Advisor);给业务逻辑组件创建一个代理对象(cglib)
 *  5）、执行目标方法
 *   1、代理对象执行目标方法
 *   2、CglibAopProxy.intercept()
 *   	1)得到目标方法的拦截器（增强器包装成拦截器MethodInterceptor）
 *   	2)利用拦截器的链式机制，依次进入每一个拦截器进行执行
 *   	3)效果：见控制台打印
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "com.hss.customAspect")
public class AopConfig {
}