package com.example.demo.logging;

import com.example.demo.service.UserService;
import nl.altindag.log.LogCaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.support.MessageSourceAccessor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private MessageSourceAccessor accessor;
    private UserService service;

    @Before
    public void setUp() {
        accessor = Mockito.mock(MessageSourceAccessor.class);
        LogTool.setMessageSourceAccessor(accessor);
        service = new UserService();
    }

    @Test
    public void warn_should_resolve_message_and_log() {
        // Arrange
        when(accessor.getMessage(eq("W1234"),eq(new Object[]{"1"}),anyString()))
            .thenReturn("ユーザーID 1 は参照権限のみです。");

        LogCaptor captor = LogCaptor.forClass(UserService.class);

        // Act
        service.authenticateReference("1");

        // Assert（getMessage の引数検証）
        verify(accessor, times(1))
            .getMessage(eq("W1234"), eq(new Object[]{"1"}), anyString());

        // Assert（最終 warn ログの本文）
        assertThat(captor.getWarnLogs())
            .anyMatch(s -> s.contains("ユーザーID 1 は参照権限のみです。"));
    }
}
