package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * コントローラが返すレスポンスのモデル
 * → ドメインを表す entity：アプリが扱うデータ構造（＝モデル）
 */
@Data
@AllArgsConstructor
public class Message {
    private String text;
}