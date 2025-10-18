package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
// ✅ Spring コンテナ（ApplicationContext）が生成される
// ✅ コンポーネントスキャン開始
// ✅ @Configuration / @Component / @RestController / @Service / @Repository 等をスキャン
// ✅ Bean を 1つずつ生成して登録する
	}

}
