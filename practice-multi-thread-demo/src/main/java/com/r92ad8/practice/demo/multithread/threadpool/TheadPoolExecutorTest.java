package com.r92ad8.practice.demo.multithread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.*;

public class TheadPoolExecutorTest {

    /**
     * 使用谷歌的guava框架
     * ThreadPoolExecutor参数解释
     * 1.corePoolSize 核心线程池大小
     * 2.maximumPoolSize 线程池最大容量大小
     * 3.keepAliveTime 线程池空闲时，线程存活的时间
     * 4.TimeUnit 时间单位
     * 5.ThreadFactory 线程工厂
     * 6.BlockingQueue任务队列
     * 7.RejectedExecutionHandler 线程拒绝策略
     */
    public static final ExecutorService threadPoolExecutor = new CustomerThreadPoolExecutor(10, 20,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), new ThreadFactoryBuilder().setNameFormat("thread-pool-executor-%d").build(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " execute.....");
            });
        }
    }

    /**
     * 自定义ThreadPoolExecutor,解决MDC上下文透传问题
     *
     * @author Fangzhengjie
     * @date 2020-04-08
     */
    private static class CustomerThreadPoolExecutor extends ThreadPoolExecutor {

        public CustomerThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, AbortPolicy abortPolicy) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, abortPolicy);
        }

        @Override
        public void execute(Runnable command) {
            Map<String, String> map = MDC.getCopyOfContextMap();
            super.execute(() -> {
                if(map!=null){
                    MDC.setContextMap(map);
                }
                command.run();
            });
        }
    }
}




