package com.example.demo.service;

import org.slf4j.LoggerFactory;

import com.example.demo.logging.CustomLogger;
import com.example.demo.logging.LogTool;
import org.slf4j.Logger;

public class UserService {

    private static final CustomLogger log = LogTool.get(UserService.class);

    public void authenticateReference(String userId) {
        log.warn("W1234", userId);
    }

    private static final Logger log2 = LoggerFactory.getLogger(UserService.class);

    public void SLF4J() {
        String userId = "1";
        log2.warn("warning", userId);
    }
}
