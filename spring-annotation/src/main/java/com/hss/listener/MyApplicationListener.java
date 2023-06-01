package com.hss.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

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
        System.out.println("收到事件：" + event);
    }
}
