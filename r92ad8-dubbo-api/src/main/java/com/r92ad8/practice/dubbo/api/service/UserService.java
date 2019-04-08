package com.r92ad8.practice.dubbo.api.service;

import com.r92ad8.practice.dubbo.api.dto.UserDTO;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
public interface UserService {

    boolean addUser(UserDTO userDTO);
}
