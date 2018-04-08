package com.yf.tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * tomcat 部署 必须实现 SpringBootServletInitializer 类  重写 configure方法
 */
@SpringBootApplication
public class TomcatApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TomcatApplication.class,args);
    }

    //spring-boot提供的解决方案：生成tomcat服务器能管理的war包，而非内嵌的tomcat直接生成的jar包

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TomcatApplication.class);
    }

}
