package com.r92ad8.dubbo.user.api.consumer.service;

import com.r92ad8.dubbo.user.api.consumer.dto.UserDTO;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
public interface UserService {

    boolean addUser(UserDTO userDTO);
}
