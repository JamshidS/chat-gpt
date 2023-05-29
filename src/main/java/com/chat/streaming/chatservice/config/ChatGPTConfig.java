package com.chat.streaming.chatservice.config;

import org.springframework.beans.factory.annotation.Value;

public class ChatGPTConfig {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String API_KEY = "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";
    public static final String MODEL = "gpt-3.5-turbo";
    public static final Integer MAX_TOKEN = 300;
    public static final Double TEMPERATURE = 0.7;
    public static final Double TOP_P = 1.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";

    public static final String URL = "https://api.openai.com/v1/chat/completions";
}
