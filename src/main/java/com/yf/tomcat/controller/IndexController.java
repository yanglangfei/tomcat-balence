package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/index")
    public  ModelAndView toIndex(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("user","alias");
        return modelAndView;
    }



}
