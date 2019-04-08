package com.r92ad8.practice.admin.web.filter;

import com.r92ad8.practice.core.entity.CommonParams;
import com.r92ad8.practice.core.entity.CommonParamsManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 权限认证过滤器
 *
 * @author fangzhengjie
 * @date 2018-09-11
 */
@Component
@WebFilter(filterName = "authorizationFilter", urlPatterns = "/*")
@Slf4j
public class AuthorizationFilter implements Filter {
    /**
     * 未知
     */
    private static final String UN_KNOW = "unknown";

    /**
     * 初始化
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {
        //暂无实现
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 检查url是否不需要验证
        String uri = request.getRequestURI();
        // appId
        String appId = request.getParameter("appId");
        // 版本号
        String version = request.getParameter("version");
        //签名
        String sign = request.getParameter("sign");
        // 客户端ip地址
        String ip = getClientIp(request);
        String userAgent = request.getHeader("User-Agent");
        CommonParams commonParams = new CommonParams(ip, appId, version, sign, userAgent);
        CommonParamsManager.set(commonParams);
        chain.doFilter(request, response);
        CommonParamsManager.remove();
        long end = System.currentTimeMillis();
        log.info("url:{}  totalTime:{}ms ", uri, end - begin);
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        //暂无实现
    }


    /**
     * 获取客户端 ip
     *
     * @param request
     * @return
     */
    private static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UN_KNOW.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UN_KNOW.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UN_KNOW.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (StringUtils.isNotBlank(ip)) {
            ip = ip.split(",")[0];
        }

        return ip;
    }
}
