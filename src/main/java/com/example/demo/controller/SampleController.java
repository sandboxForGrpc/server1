package com.example.demo.controller;

import com.example.demo.config.SampleConfig;
import com.example.demo.entity.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web層: HTTPリクエストを受け、レスポンスを返す
 * 
 */
@RestController
public class SampleController {

    @Autowired
    private SampleConfig config; 

    @GetMapping("/sample")
    public Message sayHello() {
        String text = "Hello from " + config.getName();
        return new Message(text);
    }
}
