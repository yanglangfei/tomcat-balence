package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class IndexController {

    @GetMapping("/index")
    public  ModelAndView toIndex( HttpServletRequest request, HttpServletResponse response){
        HttpSession session =request.getSession();
        session.setAttribute("user","alias");
        Cookie cookie=new Cookie("USER_ID", UUID.randomUUID().toString());
        cookie.setValue("alias");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("user","alias");
        response.addHeader("cache-control", "max-age=7200");
        return modelAndView;
    }

}
