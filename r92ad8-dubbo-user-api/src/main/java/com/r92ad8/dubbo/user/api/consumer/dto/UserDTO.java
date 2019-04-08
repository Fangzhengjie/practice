package com.r92ad8.dubbo.user.api.consumer.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author fangzhengjie
 * @date 2019-03-30
 */
@Data
@ToString
@Builder
@EqualsAndHashCode
@Accessors(chain = true)
public class UserDTO implements Serializable {

    private String userName;

    private String password;

    private String email;

}
