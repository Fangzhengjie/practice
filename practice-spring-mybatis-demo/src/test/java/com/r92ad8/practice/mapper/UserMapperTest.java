package com.r92ad8.practice.mapper;


import com.r92ad8.practice.BaseTest;
import com.r92ad8.practice.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserMapperTest extends BaseTest{

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        User user=new User();
        user.setName("方正杰");
        user.setAge(28);
        int affectsRows=userMapper.insert(user);
        Assert.assertEquals("插入结果", 1, affectsRows);
    }

}