package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.ManagementProperties;
import java.util.Map; 

@RestController
@RequestMapping("/api/config")
public class ConfigController {

    private final ManagementProperties props;

    public ConfigController(ManagementProperties props) {
        this.props = props;
    }

    @GetMapping("/management")
    public Map<String, String> show() {
        System.out.println(props.toString());
        return props.getCustomSettings();
    }
}
