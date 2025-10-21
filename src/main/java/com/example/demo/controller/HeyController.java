package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HeyController {

  
  // 例: GET /api/hey?name=Rei
  // grpc は使用せず、単純に挨拶を返す
  @GetMapping("/api/hey")
  public Map<String, Object> hey(@RequestParam(defaultValue = "world") String name) {
    return Map.of("message", "Hey " + name + "!");
  }

}
