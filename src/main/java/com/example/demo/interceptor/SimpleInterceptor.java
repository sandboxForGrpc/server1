package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SimpleInterceptor implements HandlerInterceptor {

    // Controllerメソッドが呼ばれる「前」に実行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // System.out.println(">>> SimpleInterceptor preHandle: " + request.getRequestURI());
        return true; // trueを返さないとControllerが実行されない！
    }

    // Controllerメソッドが実行された「後」に実行（View描画前）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, org.springframework.web.servlet.ModelAndView modelAndView) {
        // System.out.println("<<< SimpleInterceptor postHandle: " + request.getRequestURI());
    }
}

// curl http://localhost:8080/api/hello
// >>> SimpleLoggingFilter BEFORE controller: /api/hello
// >>> SimpleInterceptor preHandle: /api/hello
// HelloController.hello called
// <<< SimpleInterceptor postHandle: /api/hello
// <<< SimpleLoggingFilter AFTER controller: /api/hello