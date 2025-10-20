package com.example.demo.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.MessageSourceAccessor;

public class LogTool {

    private static MessageSourceAccessor messageSourceAccessor;

    public static void setMessageSourceAccessor(MessageSourceAccessor accessor) {
        messageSourceAccessor = accessor;
    }

    public static CustomLogger get(Class<?> clazz) {
        Logger base = LoggerFactory.getLogger(clazz);
        if (messageSourceAccessor == null) {
            throw new IllegalStateException("MessageSourceAccessor is not set");
        }
        return new CustomLogger(base, messageSourceAccessor);
    }
}
