package com.example.javaaichatbot.repository;

import com.example.javaaichatbot.model.Conversation;
import com.example.javaaichatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    @Query("SELECT c FROM Conversation c WHERE c.user = :user ORDER BY c.createdAt")
    List<Conversation> findByUserOrderByCreatedAtDesc(@Param("user") User user);

    @Query("SELECT c FROM Conversation c WHERE c.user = :user AND c.id = :id")
    Optional<Conversation> findByUserAndId(@Param("user") User user, @Param("id") Long id);

    @Query("DELETE FROM Conversation c WHERE c.id = :id")
    void deleteById(@Param("id") Long id);

    @Query("DELETE FROM Message m WHERE m.conversation.id = :conversationId")
    void deleteMessagesByConversationId(@Param("conversationId") Long conversationId);

    @Query("DELETE FROM Conversation c WHERE c.user.id = :userId")
    void deleteAllByUserId(@Param("userId") Long userId);
}