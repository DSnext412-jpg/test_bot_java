package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import com.example.javaaichatbot.model.Message;
import com.example.javaaichatbot.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AIService {

    ChatResponse generateResponse(ChatRequest request);

    String generateResponseText(ChatRequest request);

    // For future: generateResponse with conversation history
    // ChatResponse generateResponseWithHistory(ChatRequest request, List<Message> history);
}