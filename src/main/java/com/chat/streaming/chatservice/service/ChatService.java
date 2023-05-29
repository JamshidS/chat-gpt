package com.chat.streaming.chatservice.service;

import com.chat.streaming.chatservice.dto.ChatDto;
import com.chat.streaming.chatservice.dto.ChatRequest;
import com.chat.streaming.chatservice.dto.ChatResponse;

public interface ChatService {
    String getChat(ChatDto prompt);
}
