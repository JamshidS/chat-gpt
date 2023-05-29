package com.chat.streaming.chatservice.service;

import com.chat.streaming.chatservice.dto.ChatRequest;
import com.chat.streaming.chatservice.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Service
public class ChatServiceImpl implements ChatService{

    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.api.key}")
    private String openAIAPIKey;
    @Override
    public String getChat(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openAIAPIKey);

        ChatRequest request = new ChatRequest(model, prompt);
        HttpEntity<ChatRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ChatResponse> responseEntity = restTemplate.postForEntity(apiUrl, entity, ChatResponse.class);
        ChatResponse response = responseEntity.getBody();

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        return response.getChoices().get(0).getMessage().getContent();
    }
}
