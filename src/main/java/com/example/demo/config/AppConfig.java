// src/main/java/com/example/demo/config/AppConfig.java
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.core.GreetingService;
import com.example.demo.core.impl.SimpleGreetingService;


@Configuration // 構成クラス（Beanを作る工場）
public class AppConfig {

  @Bean // コンテナに登録されるBean定義（デフォルトはシングルトン）
  public GreetingService greetingService() {
    return new SimpleGreetingService();
  }
  // SimpleGreetingService のインスタンスが生成され、
  // greetingService という Bean 名で、GreetingService 型として Spring に登録される
  // @Configuration + @Bean は「メソッドで Bean を生成するための特別ルール」
}