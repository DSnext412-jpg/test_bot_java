package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AIServiceTest {

    @Test
    void chatRequestHasMessageField() {
        ChatRequest request = new ChatRequest();
        request.setMessage("Test message");
        assertNotNull(request.getMessage());
    }

    @Test
    void chatResponseHasResponseField() {
        ChatResponse response = new ChatResponse();
        response.setResponse("Test response");
        assertNotNull(response.getResponse());
    }
}