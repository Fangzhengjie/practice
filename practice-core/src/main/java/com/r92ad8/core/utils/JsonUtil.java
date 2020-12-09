package com.r92ad8.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;

/**
 * json工具类
 *
 * @author fangzhengjie
 * @date 2018-09-11
 */
public class JsonUtil {

    private static SerializerFeature[] features = {SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue};

    /**
     * 私有构造方法
     */
    private JsonUtil() {
    }

    public static String toJson(Object obj) {
        if (obj == null) {
            return null;
        }
        return JSON.toJSONString(obj, features);
    }

    public static <T> T parseObject(String text, Class<T> type) {
        return JSON.parseObject(text, type);
    }

    public static <T> List<T> parseList(String json, Class<T> cls) {
        return JSON.parseArray(json, cls);
    }

    public static Map<String, Object> parseMap(String json) {
        return (Map) JSON.parseObject(json, Map.class);
    }
}