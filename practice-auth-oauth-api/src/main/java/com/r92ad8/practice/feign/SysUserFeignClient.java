package com.r92ad8.practice.feign;


import com.r92ad8.practice.feign.fallback.SysUserFeignClientFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "sys-user-api",fallbackFactory = SysUserFeignClientFallBackFactory.class,decode404 = true)
public class SysUserFeignClient{


}
