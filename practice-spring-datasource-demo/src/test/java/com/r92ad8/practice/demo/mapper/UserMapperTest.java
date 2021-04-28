package com.r92ad8.practice.demo.mapper;


import com.r92ad8.datasource.mapper.UserMapper;
import com.r92ad8.practice.demo.SpringMybatisDemoApplicationTest;
import com.r92ad8.datasource.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends SpringMybatisDemoApplicationTest {
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