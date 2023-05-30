package com.chat.streaming.chatservice.service;

import com.chat.streaming.chatservice.dto.ChatDto;
import com.chat.streaming.chatservice.dto.ChatRequest;
import com.chat.streaming.chatservice.dto.ChatResponse;
import com.chat.streaming.chatservice.dto.Choice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatServiceImplTest {

    @Qualifier("openaiRestTemplate")
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks private ChatServiceImpl underTest;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getChat() {
        //given
        ChatDto chatDto = new ChatDto();
        chatDto.setMessage("test-message");
        ChatRequest request=new ChatRequest(model, chatDto.getMessage());
        ChatResponse response = new ChatResponse();
        List<ChatResponse.Choice> choiceList = new ArrayList<>();
        choiceList.add(new ChatResponse.Choice(0,request.getMessages().get(0)));
        response.setChoices(choiceList);

        //when
        Mockito.when(restTemplate.postForObject(apiUrl, request, ChatResponse.class)).thenReturn(response);
        String responseFromService = underTest.getChat(chatDto);

        //then
        assertEquals(response.getChoices().get(0).getMessage().getContent(),responseFromService);
        Mockito.verify(restTemplate,Mockito.times(1)).postForObject(apiUrl,request,ChatResponse.class);
    }
}