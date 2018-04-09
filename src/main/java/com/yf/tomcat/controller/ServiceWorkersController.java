package com.yf.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * PWA 技术的研究中发现 PWA 其中有三个关键的技术
 * Service Worker
 * Manifest （应用清单）
 * Push Notification（推送通知）
 *
 * Service Worker的功能还是比较逆天的
 *   后台数据的同步
     从其他域获取资源请求
     接受计算密集型数据的更新，多页面共享该数据
     客户端编译与依赖管理
     后端服务的hook机制
     根据URL模式，自定义模板
     性能优化
     消息推送
     定时默认更新
     地理围栏
 */
@Controller
public class ServiceWorkersController {

    @GetMapping("/toServiceWorkers")
    public  String toServiceWorkers(Model model){
        return "/view/service_workers";
    }

}
