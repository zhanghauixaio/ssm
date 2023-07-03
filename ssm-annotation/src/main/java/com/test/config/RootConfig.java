package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 扫描除了controller其他的类
 */
@Configuration
@ComponentScan(basePackages = {"com.test"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {
}
