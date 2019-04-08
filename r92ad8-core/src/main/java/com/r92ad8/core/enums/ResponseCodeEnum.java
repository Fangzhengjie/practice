package com.r92ad8.core.enums;

/**
 * 返回状态码和描述
 *
 * @author fangzhengjie
 * @date 2019-01-01
 */
public enum ResponseCodeEnum {

    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),

    /**
     * 服务器异常
     */
    FAILURE(0, "服务器异常"),

    ;
    public final int code;

    public final String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
