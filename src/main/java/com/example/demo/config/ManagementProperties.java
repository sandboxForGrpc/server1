package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;
import java.util.Map;

@Component
@ConfigurationProperties("management")
@Data  // ← Lombokで getter/setter/toString 等を自動生成
public class ManagementProperties {

    // application.yaml の management.custom-settings を受け取る
    private Map<String, String> customSettings;
}
