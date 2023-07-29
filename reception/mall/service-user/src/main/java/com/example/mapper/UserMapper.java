package com.example.mapper;

import com.example.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 22:24
 */
public interface UserMapper extends Mapper<User> {

    int insertUser(User user);
}
