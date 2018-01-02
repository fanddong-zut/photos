package com.fsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FDD on 2017/12/26.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
