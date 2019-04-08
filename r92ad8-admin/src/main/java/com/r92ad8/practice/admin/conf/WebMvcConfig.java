package com.r92ad8.practice.admin.conf;

import com.r92ad8.practice.admin.web.interceptor.LogWatchHandlerInterceptor;
import com.r92ad8.practice.core.constants.ModuleNameConstant;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * web
 *
 * @author fangzhengjie
 * @date 2018年9月12日
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 允许跨域调用的过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return new CorsFilter(source);
    }


    /**
     * 日志拦截
     *
     * @return
     */
    @Bean
    public LogWatchHandlerInterceptor logWatchHandlerInterceptor() {
        LogWatchHandlerInterceptor logWatchHandlerInterceptor = new LogWatchHandlerInterceptor();
        logWatchHandlerInterceptor.setModuleName(ModuleNameConstant.EAST_WIND_ADMIN);
        return logWatchHandlerInterceptor;
    }

    /**
     * 添加拦截器（名称必须是addInterceptors）
     *
     * @author fangzhengjie
     * @date 2018年1月16日
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置访问超时拦截器
        registry.addInterceptor(logWatchHandlerInterceptor()).addPathPatterns("/**");
    }

}
