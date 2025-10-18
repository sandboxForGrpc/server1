package com.example.demo.core.impl;

import com.example.demo.core.GreetingService;

public class SimpleGreetingService implements GreetingService {
  @Override
  public String greet(String name) {
    return "Hello, " + name + "!";
  }
}