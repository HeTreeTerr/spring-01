package com.hss.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

/**
 * <p>
 * ApplicationListener：监听容器中发布的事件，事件驱动模型开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *      监听ApplicationEvent及下面的子事件
 *
 * 步骤：
 *  1）、写一个监听器来监听某个事件(ApplicationEvent及其子类)
 *  2）、把监听器加入到容器；
 *  3）、只要容器中有相关的事件发布，我们就能监听到这个事件；
 *      ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件；
 *      ContextClosedEvent：关闭容器会发布这个事件
 *
 * 原理
 * 事件多播器（派发器）
 * 1）、创建容器对象:refresh();
 * 2）、initApplicationEventMulticaster();初始化applicationEventMulticaster;
 *      1）、先去容器中找有没有id="applicationEventMulticaster"的组件；
 *      2）、如果没有this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *          并且加入到容器中，我们就可以在其他组件中派发时间，自动注入到这个applicationEventMulticaster;
 *
 * 容器中有哪些监听器
 * 1）、创建容器对象:refresh();
 * 2）、registerListeners();
 *      从容器中拿到所有的监听器，把他们注册到applicationEventMulticaster中;
 *      String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *      //将listener注册到applicationEventMulticaster中
 *      getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 * @EventListener:
 *      EventListenerMethodProcessor implements SmartInitializingSingleton, ApplicationContextAware
 * 重心：SmartInitializingSingleton -> afterSingletonsInstantiated();
 *      1）、创建容器对象:refresh();
 *      2）、finishBeanFactoryInitialization(beanFactory);初始化生下的单实例bean;
 *          1）、先创建所有的单实例bean:getBean();
 *          2）、获取所有创建好的单实例bean，判断是否是SmartInitializingSingleton类型的；
 *              所过是就调用afterSingletonsInstantiated();
 * </p>
 *
 * @author Hss
 * @date 2023-06-01
 */
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    /**
     * 当容器中此事件发布以后，方法触发
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("onApplicationEvent...收到事件：" + event);
    }

    @EventListener
    public void eventListenerTag(ApplicationEvent event){
        System.out.println("eventListenerTag...收到事件：" + event);
    }
}
