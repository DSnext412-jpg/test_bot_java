package com.example.javaaichatbot.controller;

import com.example.javaaichatbot.ai.AIService;
import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import com.example.javaaichatbot.exception.AIServiceException;
import com.example.javaaichatbot.model.*;
import com.example.javaaichatbot.service.ConversationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final AIService aiService;
    private final ConversationService conversationService;

    @Autowired
    public ChatController(AIService aiService, ConversationService conversationService) {
        this.aiService = aiService;
        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<ChatResponse> sendMessage(@Valid @RequestBody ChatRequest request) {
        ChatResponse response = aiService.generateResponse(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/conversations")
    public ResponseEntity<List<Conversation>> getConversations() {
        return ResponseEntity.ok(conversationService.getConversationsByUser(null));
    }

    @GetMapping("/conversations/{id}")
    public ResponseEntity<Conversation> getConversation(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/conversations/{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long id) {
        return ResponseEntity.ok(conversationService.getMessagesByConversation(null));
    }

    @DeleteMapping("/conversations/{id}")
    public ResponseEntity<Void> deleteConversation(@PathVariable Long id) {
        conversationService.deleteConversation(id, null);
        return ResponseEntity.noContent().build();
    }
}