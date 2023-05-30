package com.chat.streaming.chatservice.controller;

import com.chat.streaming.chatservice.dto.ChatDto;
import com.chat.streaming.chatservice.service.ChatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ChatControllerTest {

    @Mock
    private ChatService chatService;

    @InjectMocks
    private ChatController underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void chat() {
        //given
        ChatDto chatDto = new ChatDto();
        chatDto.setMessage("test");
        String responseFromOpenAi = "something related to the test";

        //when
        Mockito.when(chatService.getChat(chatDto)).thenReturn(responseFromOpenAi);
        ResponseEntity<Object> response = underTest.chat(chatDto);

        //then
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(responseFromOpenAi,response.getBody());
        Mockito.verify(chatService,Mockito.times(1)).getChat(chatDto);
    }
}