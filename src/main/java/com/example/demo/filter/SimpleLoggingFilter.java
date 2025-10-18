package com.example.demo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component // Spring に「このクラスのインスタンスを作って、管理してね」と指示するアノテーション
public class SimpleLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // System.out.println(">>> SimpleLoggingFilter BEFORE controller: " + request.getRequestURI());

        // 次のフィルタ or コントローラへ
        filterChain.doFilter(request, response);

        // System.out.println("<<< SimpleLoggingFilter AFTER controller: " + request.getRequestURI());
    }
}


// curl http://localhost:8080/api/hello
// >>> SimpleLoggingFilter BEFORE controller: /api/hello
// HelloController.hello called
// <<< SimpleLoggingFilter AFTER controller: /api/hello