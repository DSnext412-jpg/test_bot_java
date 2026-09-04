package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public interface AIService {

    ChatResponse generateResponse(ChatRequest request);
}