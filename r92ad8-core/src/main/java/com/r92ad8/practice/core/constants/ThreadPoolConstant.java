package com.r92ad8.practice.core.constants;

/**
 * @author fangzhengjie
 * @date 2019-01-15
 */
public class ThreadPoolConstant {
    /**
     * 线程池维护线程的最少数量
     */
    public static final int corePoolSize = 10;
    /**
     * 线程池维护线程的最大数量
     */
    public static final int maxPoolSize = 30;

    /**
     * 队列容量
     */
    public static final int queueCapacity = 8;

    /**
     * 允许的空闲时间
     */
    public static final int keepAlive = 60;

    /**
     * 用户模块线程前缀
     */
    public static final String THREAD_NAME_PREFIX_USER = "r92ad8-admin-user-async";


}
