package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ChatController {

    @GetMapping("/toChat")
    public String toChat(HttpServletResponse response) {
        //设置缓存  7200 秒
        response.addHeader("cache-control", "max-age=7200");
        return "/view/chat";
    }
}
