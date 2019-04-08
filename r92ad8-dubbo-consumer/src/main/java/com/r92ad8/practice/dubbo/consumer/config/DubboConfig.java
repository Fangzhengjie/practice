package com.r92ad8.practice.dubbo.consumer.config;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
@Configuration
@EnableDubboConfig
@DubboComponentScan("com.r92ad8.dubbo.consumer.controller")
public class DubboConfig {
}
