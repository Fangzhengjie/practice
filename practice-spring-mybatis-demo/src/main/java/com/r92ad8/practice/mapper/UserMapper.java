package com.r92ad8.practice.mapper;

import com.r92ad8.practice.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    @Insert(value = "insert into user(name,age)values(#{name},#{age})")
    public int insert(User user);
}
