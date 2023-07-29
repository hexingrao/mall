package com.example.service.impl;


import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 22:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {

        user.setCreatetime(new Date());
        user.setUpdatetime(new Date());

        int num = userMapper.insert(user);

        if (num == 1) {
            return 200;
        }

        return 500;
    }

    @Override
    public int login(User user) {

        Example exampleUser = new Example(User.class);
        Example.Criteria criteriaUser = exampleUser.createCriteria();
        criteriaUser.andEqualTo("username", user.getUsername());
        criteriaUser.andEqualTo("password", user.getPassword());

        List<User> users = userMapper.selectByExample(exampleUser);

        if (users != null) {
            return 200;
        }

        return 500;
    }
}
