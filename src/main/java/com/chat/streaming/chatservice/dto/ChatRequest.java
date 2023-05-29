package com.chat.streaming.chatservice.dto;

import com.chat.streaming.chatservice.data.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatRequest {
    private String model;
    private List<Message> messageList;
    private int n;
    private double temperature;

    public ChatRequest(String model, String prompt) {
        this.model = model;

        this.messageList = new ArrayList<>();
        this.messageList.add(new Message("user", prompt));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
