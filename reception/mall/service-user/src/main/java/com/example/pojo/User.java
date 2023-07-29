package com.example.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @auther 何兴绕
 * @Date 2023年07月29日 13:13
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String nickname;

    private String password;

    private Date createtime;

    private Date updatetime;
}
