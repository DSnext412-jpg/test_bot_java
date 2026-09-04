# Architecture Documentation

## Overview

This project implements a full-stack AI chatbot using Java and Spring Boot. The application follows a clean layered architecture to ensure separation of concerns, testability, and maintainability.

## Layered Architecture

```
Controller
    ↓
Service
    ↓
AI Service
    ↓
HTTP Client
    ↓
AI API

For database operations:

Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
```

## Key Components

### 1. Controller Layer
- `ChatController`: Handles HTTP REST API endpoints for chat functionality
- Accepts and returns DTOs (Data Transfer Objects)
- Validates input using Bean Validation
- Handles exceptions globally via `GlobalExceptionHandler`

### 2. Service Layer
- `AIService` (interface) + `AIServiceImpl` (implementation): Abstracts the AI API integration
- `ConversationService`: Business logic for conversation management
- Decouples the controller from direct AI API dependencies

### 3. AI Service Layer
- `AIService` interface defines the contract for AI communication
- `AIServiceImpl` implements the interface using `RestTemplate`
- Handles HTTP requests, JSON parsing, error handling, and response extraction
- Configuration is isolated in `AIConfig` class

### 4. Repository Layer
- `UserRepository`: JPA repository for User entities
- `ConversationRepository`: JPA repository for Conversation entities with custom queries
- `MessageRepository`: JPA repository for Message entities with custom queries
- Uses Spring Data JPA with Hibernate for PostgreSQL/H2

### 5. Model Layer
- `User`: Represents registered users with username, email, and password hash
- `Conversation`: Represents chat conversations linked to a user
- `Message`: Represents individual messages with role (USER/ASSISTANT/SYSTEM)

### 6. DTO Layer
- `ChatRequest`: Input DTO with message field and validation
- `ChatResponse`: Output DTO with response field

### 7. Configuration Layer
- `AIConfig`: Reads AI API configuration from environment variables
- `AppConfig`: Spring bean configuration for RestTemplate
- `SecurityConfig`: HTTP security configuration with form login

## Data Flow

1. **Chat Request**: Frontend sends POST /api/chat with {message: "..."}
2. **Validation**: ChatRequest is validated for non-empty, non-too-long messages
3. **AI Service**: AIServiceImpl builds HTTP request to AI API
4. **HTTP Client**: RestTemplate sends POST request with JSON body
5. **AI API**: External AI service processes request and returns response
6. **Response Parsing**: JSON response is mapped to ChatResponse
7. **Return**: Clean JSON {response: "..."} is returned to frontend

## Database Schema

### Users Table
- id (Primary Key, Auto-Generated)
- username (Unique, Not Blank)
- email (Unique, Valid Email, Not Blank)
- password (Not Blank, Min 8 chars)
- created_at (Timestamp)
- updated_at (Timestamp)

### Conversations Table
- id (Primary Key, Auto-Generated)
- title (Not Blank, Max 100 chars)
- created_at (Timestamp)
- updated_at (Timestamp)
- user_id (Foreign Key -> Users)

### Messages Table
- id (Primary Key, Auto-Generated)
- content (TEXT, Not Blank)
- role (Enum: USER, ASSISTANT, SYSTEM)
- created_at (Timestamp)
- conversation_id (Foreign Key -> Conversations)

## Security

- Form-based authentication with Spring Security
- Login endpoint: POST /api/auth/login
- Protected endpoints: /api/chat/**, /api/conversations/**
- Public endpoints: /api/auth/**, /, /css/**, /js/**

## Error Handling

Centralized exception handling via `GlobalExceptionHandler`:
- AIServiceException: AI API errors (500)
- Generic Exception: Unexpected errors (500)
- ConstraintViolationException: Validation errors (400)
- AccessDeniedException: Access errors (401)
- NoSuchElementException: Resource not found (404)
- Rate limit handling (429)