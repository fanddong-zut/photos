package com.fsky.controller;

import com.fsky.entity.User;
import com.fsky.entity.UserInfo;
import com.fsky.repository.UserInfoRepository;
import com.fsky.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by FDD on 2017/12/26.
 */
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(String logname, String logpass, Model model, HttpSession session) {
        User user = userRepository.findByUserNameAndPassword(logname, logpass);
        Boolean flag = user == null ? false : true;
        if (flag) {
            logger.info("User {} login Sccess", logname);
            UserInfo userInfo = userInfoRepository.findByUserName(user.getUserName());
            session.setAttribute("user", user);//基本信息
            session.setAttribute("userInfo", userInfo);//联系信息
            return "default";
        }
        logger.info("User {} login failed", logname);
        model.addAttribute("error", "账户名或密码错误");
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }

    @GetMapping("/auth/default")
    public String defaultPage() {
        return "default";
    }

}
