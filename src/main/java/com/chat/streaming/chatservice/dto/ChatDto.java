package com.chat.streaming.chatservice.dto;


public class ChatDto {
    private String message;

    public ChatDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
