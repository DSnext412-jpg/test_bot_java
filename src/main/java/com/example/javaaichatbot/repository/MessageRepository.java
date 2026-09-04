package com.example.javaaichatbot.repository;

import com.example.javaaichatbot.model.Message;
import com.example.javaaichatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.conversation.id = :conversationId ORDER BY m.createdAt")
    List<Message> findByConversationId(@Param("conversationId") Long conversationId);

    @Query("DELETE FROM Message m WHERE m.conversation.id = :conversationId")
    void deleteByConversationId(@Param("conversationId") Long conversationId);
}