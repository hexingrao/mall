package com.example.service;

import com.example.pojo.User;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 22:20
 */
public interface UserService {

    int register(User user);

    int login(User user);
}
