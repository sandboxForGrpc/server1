package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

/**
 * application.yaml の値をマッピングする設定クラス：外部設定をアプリ内に安全に取り込む
 */
@Data
@ConfigurationProperties(prefix = "sample")
public class SampleConfig {
    private String name;
}