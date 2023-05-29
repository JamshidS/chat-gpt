package com.chat.streaming.chatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<Choice> choices;
}
