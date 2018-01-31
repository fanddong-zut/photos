package com.fsky.controller;

import com.fsky.entity.Photo;
import com.fsky.entity.User;
import com.fsky.repository.PhotoRepository;
import com.fsky.repository.UserRepository;
import com.fsky.utils.DateUtil;
import com.fsky.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by FDD on 2017/12/24.
 */
@Controller
@RequestMapping("/auth/photos")
public class PhotosController {
    private static final Logger logger = LoggerFactory.getLogger(PhotosController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhotoRepository photoRepository;

    @Value("${custom.savePath}")
    private String savePath;//照片上传地址

    @GetMapping("upload")
    public String index() {
        return "upload";
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file, HttpSession session) {
        String fileName = UUIDUtils.getUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(fileName);
        try {
            file.transferTo(new File(savePath + fileName));
            User user = (User) session.getAttribute("user");
            logger.info("User {} Upload FileName {} Success", user.getUserName(), fileName);
            Photo photo = new Photo(user.getUserName(), fileName, DateUtil.getNowDateStr(),"", "");
            photoRepository.save(photo);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return "error";
        }
        return fileName;
    }
}
