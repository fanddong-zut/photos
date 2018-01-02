package com.fsky.controller;

import com.fsky.entity.User;
import com.fsky.repository.UserInfoRepository;
import com.fsky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by FDD on 2017/12/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = "/basic/{userName}")
    public User getUser(@PathVariable String userName) {
        User user = userRepository.findByUserName(userName);
        System.out.println(user);
        return user;
    }
}
