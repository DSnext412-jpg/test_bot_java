package com.example.javaaichatbot.controller;
import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.ContextLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatControllerTest {
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
