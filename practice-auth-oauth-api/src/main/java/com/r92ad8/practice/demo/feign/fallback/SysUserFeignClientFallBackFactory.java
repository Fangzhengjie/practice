package com.r92ad8.practice.demo.feign.fallback;

import com.r92ad8.practice.demo.feign.SysUserFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;


public class SysUserFeignClientFallBackFactory implements FallbackFactory<SysUserFeignClient> {

    @Override
    public SysUserFeignClient create(Throwable cause) {
        return new SysUserFeignClient(){

        };
    }
}

