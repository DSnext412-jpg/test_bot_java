package com.example.javaaichatbot.controller;

import com.example.javaaichatbot.ai.AIService;
import com.example.javaaichatbot.dto.ChatRequest;
import com.example.javaaichatbot.dto.ChatResponse;
import com.example.javaaichatbot.exception.AIServiceException;
import com.example.javaaichatbot.model.Message;
import com.example.javaaichatbot.model.User;
import com.example.javaaichatbot.model.Conversation;
import com.example.javaaichatbot.service.ConversationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ChatResponse> sendMessage(@Valid @RequestBody ChatRequest request,
                                                    @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = (User) userDetails;

        List<Conversation> conversations = conversationService.getConversationsByUser(user);
        Conversation conversation = conversations.isEmpty()
                ? conversationService.createConversation(user, "Recent")
                : conversations.get(0);

        Message userMessage = conversationService.addMessage(
                conversation.getId(), user, request.getMessage(), Message.Role.USER);

        try {
            ChatResponse response = aiService.generateResponse(request);

            Message assistantMessage = conversationService.addMessage(
                    conversation.getId(), user, response.getResponse(), Message.Role.ASSISTANT);

            return ResponseEntity.ok(response);
        } catch (AIServiceException e) {
            return ResponseEntity.status(503)
                    .body(new ChatResponse("AI service temporarily unavailable. Your message has been saved."));
        }
    }

    @GetMapping("/conversations")
    public ResponseEntity<List<Conversation>> getConversations(@AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        return ResponseEntity.ok(conversationService.getConversationsByUser(user));
    }

    @GetMapping("/conversations/{id}")
    public ResponseEntity<Conversation> getConversation(@PathVariable Long id,
                                                      @AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        return ResponseEntity.ok(conversationService.getConversationById(id, user));
    }

    @GetMapping("/conversations/{id}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long id,
                                                     @AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        return ResponseEntity.ok(conversationService.getMessagesByConversation(id, user));
    }

    @DeleteMapping("/conversations/{id}")
    public ResponseEntity<Void> deleteConversation(@PathVariable Long id,
                                                 @AuthenticationPrincipal UserDetails userDetails) {
        User user = (User) userDetails;
        conversationService.deleteConversation(id, user);
        return ResponseEntity.noContent().build();
    }
}