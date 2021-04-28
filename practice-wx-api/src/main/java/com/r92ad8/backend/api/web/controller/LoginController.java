package com.r92ad8.backend.api.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author fangzhengjie
 * @date 2019-01-15
 */
@RestController
public class LoginController {

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(String userName, String password) {
        return null;
    }
}
