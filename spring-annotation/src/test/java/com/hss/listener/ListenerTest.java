package com.hss.listener;

import com.hss.config.ListenerConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <p>
 * spring 事件监听器基本使用
 * </p>
 *
 * @author Hss
 * @date 2023-06-01
 */
public class ListenerTest {

    public static void main(String[] args) {
        //初始化容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ListenerConfig.class);
        //bean 定义信息
        /*String[] definitionNames = ac.getBeanDefinitionNames();
        for(String name : definitionNames){
            System.out.println(name);
        }*/

        //发布事件
        ac.publishEvent(new ApplicationEvent("我发布的事件") {});

        //关闭容器
        ac.close();
    }
}
