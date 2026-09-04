package com.example.javaaichatbot.config;

import org.springframework.stereotype.Component;

@Component
public class AIConfig {

    private final String apiUrl;
    private final String apiKey;
    private final String modelName;
    private final int timeout;

    public AIConfig() {
        this.apiUrl = System.getenv().getOrDefault("AI_API_URL", "http://localhost:8080");
        this.apiKey = System.getenv().getOrDefault("AI_API_KEY", "");
        this.modelName = System.getenv().getOrDefault("AI_MODEL_NAME", "gpt-3.5-turbo");
        this.timeout = Integer.parseInt(
                System.getenv().getOrDefault("AI_TIMEOUT", "30000")
        );
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getModelName() {
        return modelName;
    }

    public int getTimeout() {
        return timeout;
    }
}