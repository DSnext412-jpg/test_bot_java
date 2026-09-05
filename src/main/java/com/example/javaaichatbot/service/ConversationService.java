package com.example.javaaichatbot.service;

import com.example.javaaichatbot.model.Message;
import com.example.javaaichatbot.model.User;
import com.example.javaaichatbot.model.Conversation;
import com.example.javaaichatbot.repository.MessageRepository;
import com.example.javaaichatbot.repository.ConversationRepository;
import com.example.javaaichatbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    public Conversation createConversation(User user, String title) {
        Conversation conversation = new Conversation();
        conversation.setTitle(title);
        conversation.setUser(user);
        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversationsByUser(User user) {
        return conversationRepository.findByUserOrderByCreatedAtDesc(user);
    }

    public Conversation getConversationById(Long conversationId, User user) {
        return conversationRepository.findByUserAndId(user, conversationId)
                .orElseThrow(() -> new IllegalArgumentException("Conversation not found or does not belong to user"));
    }

    @Transactional
    public void deleteConversation(Long conversationId, User user) {
        getConversationById(conversationId, user);
        messageRepository.deleteByConversationId(conversationId);
        conversationRepository.deleteById(conversationId);
    }

    public List<Message> getMessagesByConversation(Long conversationId, User user) {
        getConversationById(conversationId, user);
        return messageRepository.findByConversationId(conversationId);
    }

    @Transactional
    public Message addMessage(Long conversationId, User user, String content, Message.Role role) {
        Conversation conversation = getConversationById(conversationId, user);
        Message message = new Message();
        message.setContent(content);
        message.setRole(role);
        message.setConversation(conversation);
        return messageRepository.save(message);
    }
}