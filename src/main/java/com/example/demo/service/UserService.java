package com.example.demo.service;

import com.example.demo.logging.CustomLogger;
import com.example.demo.logging.LogTool;

public class UserService {

    private static final CustomLogger log = LogTool.get(UserService.class);

    public void authenticateReference(String userId) {
        log.warn("W1234", userId);
    }
}
