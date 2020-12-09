package com.r92ad8.core.entity;

import java.io.Serializable;

/**
 * 功能描述  公共参数类
 *
 * @author fangzhengjie
 * @date 2019-01-01
 */
public class CommonParams implements Serializable {

    /**
     * ip地址
     */
    private String ip;

    /**
     * 版本号
     */
    private String version;

    /**
     * appId
     */
    private String appId;

    /**
     * 签名
     */
    private String sign;

    /**
     * 浏览器用于 HTTP 请求的用户代理头的值。
     */
    private String userAgent;

    public CommonParams() {
    }

    public CommonParams(String ip, String version, String appId, String sign, String userAgent) {
        super();
        this.ip = ip;
        this.version = version;
        this.appId = appId;
        this.sign = sign;
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "{\"ip\":\"" + ip + "\",\"appId\":\"" + appId + "\",\"version\":\"" + version + "\",\"sign\":\"" + sign + "\",\"userAgent\":\"" + userAgent + "\"}";
    }
}
