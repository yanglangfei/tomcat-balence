package com.yf.tomcat.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        // session 的创建


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        // session 的销毁

    }
}
