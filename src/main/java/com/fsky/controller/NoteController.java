package com.fsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by FDD on 2018/1/16.
 */
@Controller
@RequestMapping("/auth/note")
public class NoteController {

    @GetMapping("write")
    public String writeNote() {
        return "note_write";
    }
}
