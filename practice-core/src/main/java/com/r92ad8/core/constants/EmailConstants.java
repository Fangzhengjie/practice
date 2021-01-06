package com.r92ad8.core.constants;

/**
 * 发送邮件时使用的常量
 *
 * @author Fangzhengjie
 * @date 2020-09-10
 */
public class EmailConstants {


    /**
     * 请求地址格式化模板
     */
    public static final String REQUEST_URI_FORMAT = "【请求地址】：%s <br>";
    /**
     * 请求地址格式化模板
     */
    public static final String LOGIN_USER_FORMAT = "【操作人】：token=%s,姓名=%s,工号=%s <br>";

    /**
     * 请求方式格式化模板
     */
    public static final String REQUEST_METHOD_FORMAT = "【请求方式】：%s <br>";

    /**
     * 请求参数格式化模板
     */
    public static final String REQUEST_PARAM_FORMAT = "【请求参数】：%s <br>";

    /**
     * 请求参数格式化模板 Body String
     */
    public static final String REQUEST_BODY_STRING_FORMAT = "【请求体】：%s <br>";

    /**
     * 客户端ip格式化模板
     */
    public static final String CLIENT_IP_FORMAT = "【客户端ip】：%s <br>";

    /**
     * 服务器ip格式化模板
     */
    public static final String SERVER_IP_FORMAT = "【服务器ip】：%s <br>";

    /**
     * 用户代理信息格式化模板
     */
    public static final String USER_AGENT_FORMAT = "【User-Agent】：%s <br>";


    /**
     * 用户代理信息格式化模板
     */
    public static final String TRACE_ID_FORMAT = "【traceId】：%s <br>";

    /**
     * 请求来源信息格式化模板
     */
    public static final String REFERER_FORMAT = "【Referer】：%s <br>";

    /**
     * 堆栈信息格式化模板
     */
    public static final String STACK_TRACE_FORMAT = "&nbsp;&nbsp;&nbsp;&nbsp;%s<br>";
    /**
     * 错误信息格式化模板
     */
    public static final String ERROR_MESSAGE_FORMAT = "【错误信息】：%s <br>";

    /**
     * Request请求头中用户代理的名称
     */
    public static final String REQUEST_HEADER_USER_AGENT_NAME = "User-Agent";

    /**
     * Request请求头中请求来源名称
     */
    public static final String REQUEST_HEADER_REFERER_NAME = "Referer";

    /**
     * Request请求头中请求头为content-type
     */
    public static final String REQUEST_HEADER_CONTENT_TYPE = "Content-Type";

    /**
     * content-type为application/json
     */
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

    /**
     * content-type为multipart/form-data
     */
    public static final String CONTENT_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
}
