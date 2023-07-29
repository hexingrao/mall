package com.example.controller;

import com.example.pojo.User;
import com.example.result.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 13:12
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        System.out.println(user);
        return Result.success(user);
    }
}
