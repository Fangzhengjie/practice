package com.r92ad8.practice.demo.utils;

import com.r92ad8.core.constants.HttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.Map;

/**
 * MDC操作
 *
 * @author Fangzhengjie
 * @date 2020-04-03
 */
@Slf4j
public class MdcUtil {

    public static String generateTraceId() {
        String traceId = IdWorker.generate();
        log.info("生成traceId：{}", traceId);
        return traceId;
    }

    public static String getTraceId() {
        String traceId = MDC.get(HttpConstant.TRACE_ID);
        log.trace("获取MDC中的traceId：{}", traceId);
        if (StringUtils.isNotBlank(traceId)) {
            return traceId;
        }
        traceId = IdWorker.generate();
        log.info("生成traceId：{}", traceId);
        return traceId;
    }

    public static void setTraceId() {
        String traceId = getTraceId();
        setTraceId(traceId);
    }

    public static void setTraceId(String traceId) {
        log.info("设置MDC中的traceId：{}", traceId);
        MDC.put(HttpConstant.TRACE_ID, traceId);
    }

    public static void clear() {
        log.info("清空MDC");
        MDC.clear();
    }

    public static void setContextMap(final Map<String, String> context) {
        MDC.setContextMap(context);
    }

    public static Map<String, String> getCopyOfContextMap() {
        return MDC.getCopyOfContextMap();
    }
}
