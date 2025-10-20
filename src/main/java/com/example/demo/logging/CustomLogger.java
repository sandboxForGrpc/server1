package com.example.demo.logging;

import org.slf4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

public class CustomLogger {

    private final Logger delegate;
    private final MessageSourceAccessor accessor;

    CustomLogger(Logger delegate, MessageSourceAccessor accessor) {
        this.delegate = delegate;
        this.accessor = accessor;
    }

    /**
     * メッセージコードと引数から文面を解決し、warnで出力
     * 例: warn("W0003", "1")
     */
    public void warn(String code, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        // デフォルト文面も用意（見やすいように）
        String defaultMsg = "!" + code + "!";
        // 実際の文面を解決
        String msg = accessor.getMessage(code, args, defaultMsg);
        // ログ出力（最終的な文字列）
        delegate.warn(msg);
        // 参考：ロケール別の解決も行いたい場合は accessor.getMessage(code, args, locale) など使う
    }
}
