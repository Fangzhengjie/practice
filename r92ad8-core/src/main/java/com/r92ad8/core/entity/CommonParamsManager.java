package com.r92ad8.core.entity;

/**
 * 通用参数管理
 *
 * @author fangzhengjie
 * @date 2019-01-01
 */
public class CommonParamsManager {
    private CommonParamsManager() {
    }

    static ThreadLocal<CommonParams> local = new ThreadLocal<>();

    public static CommonParams get() {
        CommonParams commonParams = local.get();
        //为了防止NullPointException
        if (commonParams == null) {
            return new CommonParams();
        }
        return commonParams;
    }

    public static void set(CommonParams commonParams) {
        local.set(commonParams);
    }

    public static void remove() {
        local.remove();
    }
}
