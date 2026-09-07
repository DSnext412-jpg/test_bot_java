package com.example.javaaichatbot.config;
import org.springframework.stereotype.Component;
import java.time.Duration;
@Component
public class AIConfig {
    private final String apiUrl;
    private final String apiKey;
    private final String modelName;
    private final int timeout;
    public AIConfig() {
        this.apiUrl = System.getenv().getOrDefault("AI_API_URL", "https://generativelanguage.googleapis.com/v1beta");
        String key = System.getenv().get("AI_API_KEY");
        this.apiKey = key;
        this.modelName = System.getenv().getOrDefault("AI_MODEL_NAME", "gemini-1.5-flash");
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
