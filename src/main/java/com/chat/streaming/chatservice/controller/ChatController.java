package com.chat.streaming.chatservice.controller;

import com.chat.streaming.chatservice.dto.ChatDto;
import com.chat.streaming.chatservice.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Object> chat(@RequestBody ChatDto chat){
        String prompt  = chat.getMessage();
        return new ResponseEntity<>(chatService.getChat(prompt), HttpStatus.OK);
    }
}
