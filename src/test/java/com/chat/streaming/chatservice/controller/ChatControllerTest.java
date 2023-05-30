package com.chat.streaming.chatservice.controller;

import com.chat.streaming.chatservice.service.ChatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    }
}