package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.GreetingService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/api/greet")
public class GreetingController {
  //GreetingService 型のフィールド（クラス内部からアクセス可能で、一度初期化されたら変更できない）
  private final GreetingService greetingService;

  // コンストラクタ（GreetingService 型の引数を受け取り、フィールドを初期化（シングルトン））
  public GreetingController(GreetingService greetingService) {
    System.out.println("⬛︎⬜︎⬛︎⬜︎⬛︎⬜︎ 起動後に初期化される ⬛︎⬜︎⬛︎⬜︎⬛︎⬜︎");
    this.greetingService = greetingService;
  }

  //HTTP GET リクエストを処理するメソッド
  @GetMapping
  public String greet(@RequestParam(defaultValue = "world") String name) {
    System.out.println("GreetingController.greet called");
    return greetingService.greet(name);
  }
}