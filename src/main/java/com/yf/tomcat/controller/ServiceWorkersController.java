package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *   serviceWork 作用
 *  1.网络代理，转发请求，伪造响应
    2.离线缓存
    3.消息推送
    4.后台消息传递
 */
@Controller
public class ServiceWorkersController {

    @GetMapping("/toServiceWorkers")
    public  String toServiceWorkers(Model model){
        return "/view/service_workers";
    }

}
