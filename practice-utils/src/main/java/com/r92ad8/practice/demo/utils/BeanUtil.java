package com.r92ad8.practice.demo.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Bean 属性赋值工具类
 *
 * @author Fangzhengjie
 * @date 2020-12-09
 */
public class BeanUtil extends BeanUtils {

    /**
     * 集合数据的拷贝
     *
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: DTO::new)
     * @return
     */
    public static <S, T> List<T> copyList(List<S> sources, Supplier<T> target) {
        return copyList(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources:  数据源类
     * @param target:   目标类::new(eg: DTO::new)
     * @param callBack: 回调函数
     * @return
     */
    public static <S, T> List<T> copyList(List<S> sources, Supplier<T> target, BeanUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
        }
        return list;
    }


    /**
     * copy回调
     *
     * @param <S>
     * @param <T>
     */
    @FunctionalInterface
    public interface BeanUtilCallBack<S, T> {

        /**
         * 定义默认回调方法
         *
         * @param t
         * @param s
         */
        void callBack(S t, T s);
    }

}