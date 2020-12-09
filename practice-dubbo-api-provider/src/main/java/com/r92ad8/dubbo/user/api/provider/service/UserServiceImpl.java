package com.r92ad8.dubbo.user.api.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.r92ad8.dubbo.user.api.consumer.dto.UserDTO;
import com.r92ad8.dubbo.user.api.consumer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
@Service(interfaceClass = UserService.class)
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(UserDTO userDTO) {
        log.info("添加用户:{}", userDTO.toString());
        return true;
    }
}