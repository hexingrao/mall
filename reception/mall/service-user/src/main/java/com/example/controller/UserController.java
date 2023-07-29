package com.example.controller;

import com.example.pojo.User;
import com.example.result.Result;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 13:12
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        int code = userService.login(user);
        if (code == 200){
            return Result.success();
        }
        return Result.error("登陆失败");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {

        int code = userService.register(user);

        if (code == 200) {
            return Result.success();
        }

        return Result.error("登录失败");
    }
}
