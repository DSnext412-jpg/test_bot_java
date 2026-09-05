package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;

public interface AIService {

    ChatResponse generateResponse(ChatRequest request);

    String generateResponseText(ChatRequest request);
}