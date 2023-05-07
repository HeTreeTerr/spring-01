package com.hss.config;

import com.hss.service.IndexService;
import com.hss.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 循环依赖探究 配置类
 */
@Configuration
@Import(value = {IndexService.class,UserService.class})
public class CircularDependencyConfig {
}
