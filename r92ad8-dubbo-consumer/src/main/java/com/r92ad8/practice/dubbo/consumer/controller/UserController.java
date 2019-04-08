package com.r92ad8.practice.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.r92ad8.practice.dubbo.api.dto.UserDTO;
import com.r92ad8.practice.dubbo.api.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(
            application = "${dubbo.application.id}",
            url = "dubbo://127.0.0.1:20880")
    UserService userService;

    @RequestMapping("/add")
    public void addUser(@RequestParam("userName") String userName, @RequestParam("password")String password) {
        userService.addUser(UserDTO.builder().userName(userName).password(password).build());
    }
}
