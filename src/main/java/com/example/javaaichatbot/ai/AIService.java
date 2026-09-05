package com.example.javaaichatbot.ai;

import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import com.example.javaaichatbot.config.AIConfig;
import com.example.javaaichatbot.exception.AIServiceException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Service
public class AIService {

    private final AIConfig aiConfig;

    public AIService(AIConfig aiConfig) {
        this.aiConfig = aiConfig;
    }

    @Override
    public ChatResponse generateResponse(ChatRequest request) {
        String apiKey = aiConfig.getApiKey();
        if (apiKey == null || apiKey.isEmpty()) {
            throw new AIServiceException("AI API key not configured.");
        }

        String url = aiConfig.getApiUrl() + "?key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String requestJson = "{\"contents\": [{\"parts\": [{\"text\": \"" + escapeJson(request.getMessage()) + "\"}]}]}";

        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

        try {
            ResponseEntity<ChatResponse> response = new RestTemplate().exchange(
                    url,
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
            throw new AIServiceException("Error calling AI API: " + e.getMessage());
        }
    }

    @Override
    public String generateResponseText(ChatRequest request) {
        String apiKey = aiConfig.getApiKey();
        if (apiKey == null || apiKey.isEmpty()) {
            throw new AIServiceException("AI API key not configured.");
        }

        String url = aiConfig.getApiUrl() + "?key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String requestJson = "{\"contents\": [{\"parts\": [{\"text\": \"" + escapeJson(request.getMessage()) + "\"}]}]}";

        try {
            String responseBody = new RestTemplate().postForObject(url, entity, String.class);

            if (responseBody == null || responseBody.isEmpty()) {
                throw new AIServiceException("AI API returned empty response");
            }

            return parseGeminiResponse(responseBody);
        } catch (AIServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new AIServiceException("Error calling AI API: " + e.getMessage());
        }
    }

    private String escapeJson(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n");
    }

    private String parseGeminiResponse(String responseBody) {
        if (responseBody == null || responseBody.isEmpty()) {
            return "No response from AI";
        }
        try {
            int textStart = responseBody.indexOf("\"text\"");
            if (textStart > 0) {
                int colonStart = responseBody.indexOf(":", textStart) + 1;
                while (colonStart < responseBody.length() && (responseBody.charAt(colonStart) == ' ' || responseBody.charAt(colonStart) == '\n' || responseBody.charAt(colonStart) == '\r')) {
                    colonStart++;
                }
                if (colonStart < responseBody.length() && responseBody.charAt(colonStart) == '"') {
                    int quoteStart = colonStart + 1;
                    int quoteEnd = responseBody.indexOf("\"", quoteStart);
                    if (quoteEnd > quoteStart) {
                        return responseBody.substring(quoteStart, quoteEnd);
                    }
                }
            }
            return "AI response received";
        } catch (Exception e) {
            return "AI response received";
        }
    }
}