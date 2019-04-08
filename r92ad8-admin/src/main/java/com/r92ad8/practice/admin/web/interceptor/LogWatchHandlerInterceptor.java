package com.r92ad8.practice.admin.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 日志拦截器 记录超过指定时长的查询日志 需要把该拦截器放在拦截器链的第一个
 *
 * @author fangzhengjie
 * @date 2018-09-11
 */
@Slf4j
public class LogWatchHandlerInterceptor extends HandlerInterceptorAdapter {

    /**
     * 设定慢请求时长标准：缺省为500ms
     */
    private static final int SLOW_REQUEST_DURATION_LIMIT = 500;
    /**
     * 线程局部变量
     */
    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("LogWatch-StartTime");

    /**
     * 模块名
     */
    private String moduleName;

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.debug("进入LogWatchHandlerInterceptor......");
        // 1、开始时间
        long beginTime = System.currentTimeMillis();
        // 线程绑定变量（该数据只有当前请求的线程可见）
        startTimeThreadLocal.set(beginTime);
        // 继续流程
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 2、结束时间
        long endTime = System.currentTimeMillis();
        // 得到线程绑定的局部变量（开始时间）
        long beginTime = startTimeThreadLocal.get();
        // 3、消耗的时间
        long consumeTime = endTime - beginTime;
        // 从切点上获取目标方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (consumeTime > SLOW_REQUEST_DURATION_LIMIT) {
            //此处认为处理时间超过500毫秒的请求为慢请求
            //记录到日志文件
            log.info("Monitor:[module]:{},[method]:{},[duration]:{}ms,[url]:{}", moduleName, method.getName(), consumeTime, request.getRequestURL());
            if (ex != null) {
                log.info("Exception:[class]:{},[msg]:{}", ex.getClass(), ex.getMessage());
            }
        }
    }
}
