package com.r92ad8.practice.feign.fallback;

import com.r92ad8.practice.feign.SysUserFeignClient;
import feign.Logger;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignLoggerFactory;


public class SysUserFeignClientFallBackFactory implements FallbackFactory<SysUserFeignClient> {

    @Override
    public SysUserFeignClient create(Throwable cause) {
        return new SysUserFeignClient(){

        };
    }
}

