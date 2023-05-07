package com.hss.config;

import com.hss.config.aware.AwareUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AwareUtil.class})
public class AwareConfig {

}
