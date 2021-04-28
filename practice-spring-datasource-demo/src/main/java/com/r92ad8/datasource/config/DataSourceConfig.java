package com.r92ad8.datasource.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.r92ad8.practice.mapper.*")
public class DataSourceConfig {
}
