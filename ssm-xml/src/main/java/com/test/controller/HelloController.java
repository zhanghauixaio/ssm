package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    @GetMapping("login")
    public String getHello(Model model) {
        model.addAttribute("title", "Hello World");
        model.addAttribute("body", "你好");
        return "hello";
    }

}
