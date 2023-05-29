package com.chat.streaming.chatservice.service;

import com.chat.streaming.chatservice.dto.ChatDto;
import com.chat.streaming.chatservice.dto.ChatRequest;
import com.chat.streaming.chatservice.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService{


    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Override
    public String getChat(ChatDto prompt) {
        ChatRequest request=new ChatRequest(model, prompt.getMessage());
        ChatResponse chatGptResponse = restTemplate.postForObject(apiUrl, request, ChatResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
