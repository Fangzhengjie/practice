package com.r92ad8.core.entity;


import com.r92ad8.core.enums.ResponseCodeEnum;

/**
 * 响应实体
 *
 * @author fangzhengjie
 * @date 2019-01-01
 */
public class ResponseEntity<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private <T> T data;


    private ResponseEntity(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 通用成功
     *
     * @return
     */
    public static ResponseEntity success() {
        return success(null);
    }

    /**
     * 成功后有返回对象
     *
     * @param data
     * @return
     */
    public static ResponseEntity success(Object data) {
        return new ResponseEntity(ResponseCodeEnum.SUCCESS.code, ResponseCodeEnum.SUCCESS.message, data);
    }

    /**
     * 主要显示业务逻辑上的失败
     *
     * @return
     */
    public static ResponseEntity failure() {
        return failure(null);
    }

    /**
     * 主要显示业务逻辑上的失败
     *
     * @param msg
     * @return
     */
    public static ResponseEntity failure(String msg) {
        return failure(msg, null);
    }

    /**
     * 失败后有返回对象
     *
     * @param data
     * @return
     */
    public static ResponseEntity failure(Object data) {
        return failure(ResponseCodeEnum.FAILURE.message, data);
    }

    /**
     * 失败后有返回对象
     *
     * @param data
     * @return
     */
    public static ResponseEntity failure(String msg, Object data) {
        return failure(ResponseCodeEnum.FAILURE.code, msg, data);
    }

    /**
     * 具体的系统错误
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResponseEntity failure(int code, String msg) {
        return failure(code, msg, null);
    }

    /**
     * 具体的系统错误, 且有返回对象
     *
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseEntity failure(int code, String msg, Object data) {
        return new ResponseEntity(code, msg, data);
    }

    /**
     * 判断responseEntity是否是成功返回体
     *
     * @param responseEntity
     * @return
     */
    public static boolean isSuccess(ResponseEntity responseEntity) {
        return ResponseCodeEnum.SUCCESS.code == responseEntity.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
