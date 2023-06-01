package com.hss.config;

import com.hss.listener.MyApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 * spring 监听器
 * </p>
 *
 * @author Hss
 * @date 2023-06-01
 */
@Configuration
@Import(MyApplicationListener.class)
public class ListenerConfig {

}
