package com.r92ad8.practice.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {


    @PostMapping("/test")
    public void test(@RequestBody TestDto testDto) {
        log.info("{}", testDto);
    }
}
