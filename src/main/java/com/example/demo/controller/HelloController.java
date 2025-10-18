package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {
  @GetMapping("/api/hello")
  public String hello() {
    System.out.println("HelloController.hello called");
    return "Hello Spring Boot!";
  }
}