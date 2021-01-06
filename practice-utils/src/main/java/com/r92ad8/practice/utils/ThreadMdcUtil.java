package com.r92ad8.practice.utils;

import org.springframework.util.concurrent.ListenableFuture;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 多线程下的MDC操作
 *
 * @author Fangzhengjie
 * @date 2020-04-03
 */
public class ThreadMdcUtil {

    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MdcUtil.clear();
            } else {
                MdcUtil.setContextMap(context);
            }
            MdcUtil.setTraceId();
            try {
                return callable.call();
            } finally {
                MdcUtil.clear();
            }
        };
    }

    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MdcUtil.clear();
            } else {
                MdcUtil.setContextMap(context);
            }
            MdcUtil.setTraceId();
            try {
                runnable.run();
            } finally {
                MdcUtil.clear();
            }
        };
    }
}