package com.chat.streaming.chatservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class ChatServiceImplTest {

    @Qualifier("openaiRestTemplate")
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks private ChatServiceImpl underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getChat() {
    }
}