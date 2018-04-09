package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/toChat")
    public String toChat() {
        return "/view/chat";
    }
}
