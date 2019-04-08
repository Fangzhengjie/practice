package com.r92ad8.practice.admin.conf;

import com.r92ad8.practice.core.constants.ThreadPoolConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步任务的配置
 *
 * @author fangzhengjie
 * @date 2018-09-11
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public Executor userProcessExecutor() {
        ThreadPoolTaskExecutor userProcessExecutor = new ThreadPoolTaskExecutor();
        userProcessExecutor.setCorePoolSize(ThreadPoolConstant.corePoolSize);
        userProcessExecutor.setMaxPoolSize(ThreadPoolConstant.maxPoolSize);
        userProcessExecutor.setQueueCapacity(ThreadPoolConstant.queueCapacity);
        userProcessExecutor.setThreadNamePrefix(ThreadPoolConstant.THREAD_NAME_PREFIX_USER);
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
        // 对拒绝task的处理策略
        userProcessExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        userProcessExecutor.setKeepAliveSeconds(ThreadPoolConstant.keepAlive);
        userProcessExecutor.initialize();
        return userProcessExecutor;
    }


}
