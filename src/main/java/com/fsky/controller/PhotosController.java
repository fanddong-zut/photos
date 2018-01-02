package com.fsky.controller;

import com.fsky.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by FDD on 2017/12/24.
 */
@Controller
@RequestMapping("/photos")
public class PhotosController {
    private static final Logger logger = LoggerFactory.getLogger(PhotosController.class);

    @Value("${custom.savePath}")
    private String savePath;//照片上传地址

    @GetMapping("upload")
    public String index() {
        return "upload";
    }

    @PostMapping("uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file){
        String fileName =  UUIDUtils.getUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(fileName);
        try {
            file.transferTo(new File(savePath + fileName));
        } catch (IOException e) {
            logger.error(e.getMessage());
            return "error";
        }
        return fileName;
    }
}
