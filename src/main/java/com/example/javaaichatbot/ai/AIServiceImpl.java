package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import com.example.javaaichatbot.exception.AIServiceException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIServiceImpl implements AIService {

    private final RestTemplate restTemplate;

    public AIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ChatResponse generateResponse(ChatRequest request) {
        String apiUrl = "http://localhost:8080/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ChatRequest> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<ChatResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity,
                    ChatResponse.class
            );

            if (response.getBody() == null || response.getBody().getResponse() == null) {
                throw new AIServiceException("AI API returned empty response");
            }

            return response.getBody();
        } catch (AIServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new AIServiceException(
                    "Error calling AI API: " + e.getMessage());
        }
    }
}