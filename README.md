<div align="center">

# 🤖 JAVA AI CHATBOT

### A Modern AI Chat Application Built with Java & Spring Boot

<p>
  <img src="https://img.shields.io/badge/Java-21+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.2-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-Database-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
</p>

<p>
  <img src="https://img.shields.io/badge/AI-Powered-8A2BE2?style=flat-square"/>
  <img src="https://img.shields.io/badge/REST%20API-Ready-00C853?style=flat-square"/>
  <img src="https://img.shields.io/badge/JUnit-Testing-25A162?style=flat-square&logo=junit5"/>
  <img src="https://img.shields.io/badge/Status-Active%20Development-00C853?style=flat-square"/>
</p>

> **Learning Java by building something real.**

</div>

---

## ✦ Overview

**Java AI Chatbot** is a full-stack AI chatbot application built to explore modern Java backend development, REST APIs, database persistence, authentication, testing, and AI API integration.

The project connects a **Java/Spring Boot backend** with a clean browser-based chat interface and a persistent conversation system.

```text
                  ┌──────────────────┐
                  │      USER        │
                  └────────┬─────────┘
                           │
                           ▼
                  ┌──────────────────┐
                  │   CHAT FRONTEND  │
                  │ HTML / CSS / JS  │
                  └────────┬─────────┘
                           │ REST
                           ▼
                  ┌──────────────────┐
                  │   SPRING BOOT    │
                  │    REST API      │
                  └────────┬─────────┘
                           │
              ┌────────────┼────────────┐
              ▼            ▼            ▼
         ┌────────┐   ┌─────────┐  ┌──────────┐
         │   AI   │   │   JPA   │  │ Security │
         │Service │   │Hibernate│  │  Layer   │
         └────┬───┘   └────┬────┘  └──────────┘
              │             │
              ▼             ▼
        ┌──────────┐   ┌──────────┐
        │ AI API   │   │PostgreSQL│
        └──────────┘   └──────────┘
```

---

# ✨ Features

### 💬 AI Conversation

- Send messages to an AI service
- Receive AI-generated responses
- Clean chat interface
- Loading and error states

### 🧠 Conversation Management

- Create conversations
- View conversation history
- Store individual messages
- Delete conversations
- Track message roles

```text
USER
  │
  ├── Message
  │
  ▼
AI SERVICE
  │
  ├── Response
  │
  ▼
ASSISTANT
```

### 🔐 Authentication

Authentication architecture is prepared for:

- User registration
- Login
- Password hashing
- JWT-based authentication
- Authorization

### 🛡️ Error Handling

Centralized exception handling provides clean API responses for:

```text
400  Bad Request
401  Unauthorized
403  Forbidden
404  Not Found
429  Too Many Requests
500  Internal Server Error
503  AI Service Unavailable
```

### 🧪 Testing

Testing is built into the project using:

- JUnit 5
- Spring Boot Test
- Mockito
- Mock AI services

No real AI API key is required for the core test suite.

---

# 🧩 Technology Stack

| Layer | Technology |
|---|---|
| Language | Java 21+ |
| Backend | Spring Boot 3.2.2 |
| REST | Spring Web |
| ORM | Hibernate |
| Data Access | Spring Data JPA |
| Production DB | PostgreSQL |
| Development DB | H2 |
| Security | Spring Security |
| JSON | Jackson |
| Validation | Bean Validation |
| Frontend | HTML / CSS / JavaScript |
| HTTP Client | RestTemplate |
| Build | Maven |
| Testing | JUnit 5 + Mockito |

---

# 🏗️ Architecture

```text
┌─────────────────────────────────────────────┐
│                 FRONTEND                    │
│                                             │
│        HTML + CSS + JavaScript              │
└─────────────────────┬───────────────────────┘
                      │
                      │ HTTP / JSON
                      ▼
┌─────────────────────────────────────────────┐
│              SPRING BOOT API                │
│                                             │
│  Controller → Service → Repository          │
└──────────────┬──────────────────┬───────────┘
               │                  │
               ▼                  ▼
        ┌─────────────┐    ┌──────────────┐
        │  AI SERVICE │    │   DATABASE   │
        │             │    │              │
        │ HTTP / JSON │    │ PostgreSQL   │
        └──────┬──────┘    │ H2           │
               │           └──────────────┘
               ▼
          AI PROVIDER
```

---

# 📁 Project Structure

```text
java-ai-chatbot/
│
├── src/
│   │
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/javaaichatbot/
│   │   │       │
│   │   │       ├── ai/
│   │   │       │   └── AIService
│   │   │       │
│   │   │       ├── config/
│   │   │       │
│   │   │       ├── controller/
│   │   │       │
│   │   │       ├── dto/
│   │   │       │
│   │   │       ├── exception/
│   │   │       │
│   │   │       ├── model/
│   │   │       │
│   │   │       ├── repository/
│   │   │       │
│   │   │       ├── security/
│   │   │       │
│   │   │       ├── service/
│   │   │       │
│   │   │       └── util/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │
│   └── test/
│
├── docs/
│   ├── architecture.md
│   ├── api.md
│   ├── learning-guide.md
│   └── README.md
│
├── LEARNING.md
├── pom.xml
└── README.md
```

---

# 🚀 Getting Started

## Requirements

Make sure you have:

```text
Java 21+
Maven 3.9.6+
PostgreSQL (optional for development)
AI API Key
```

---

## 1. Clone

```bash
git clone <repository-url>

cd java-ai-chatbot
```

---

## 2. Install Dependencies

```bash
mvn clean install
```

---

## 3. Configure Environment

```bash
export AI_API_URL=http://localhost:8080
export AI_API_KEY=your_api_key
export ADMIN_PASSWORD=your_secure_password
```

> On Windows PowerShell, use `$env:VARIABLE="value"`.

---

## 4. Run

```bash
mvn spring-boot:run
```

Or:

```bash
java -jar target/java-ai-chatbot-1.0.0.jar
```

Then open:

```text
http://localhost:8080
```

---

# 🔑 Environment Variables

| Variable | Default | Purpose |
|---|---|---|
| `AI_API_URL` | `http://localhost:8080` | AI API base URL |
| `AI_API_KEY` | Required | AI provider authentication |
| `ADMIN_PASSWORD` | `admin123` | Admin configuration |

### ⚠️ Security

**Never commit your API key or passwords to GitHub.**

Use environment variables or a local configuration file that is excluded from Git.

---

# 🌐 API

## Chat

| Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/api/chat` | Send message |
| `GET` | `/api/conversations` | List conversations |
| `GET` | `/api/conversations/{id}` | Get conversation |
| `GET` | `/api/conversations/{id}/messages` | Get messages |
| `DELETE` | `/api/conversations/{id}` | Delete conversation |

## Authentication

| Method | Endpoint | Purpose |
|---|---|---|
| `POST` | `/api/auth/register` | Register |
| `POST` | `/api/auth/login` | Login |

---

# 💻 Example Request

```bash
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d "{\"message\":\"Explain Java inheritance\"}"
```

Example flow:

```text
Request
   ↓
Controller
   ↓
Validation
   ↓
Chat Service
   ↓
AI Service
   ↓
AI Provider
   ↓
Response
   ↓
Database
   ↓
Frontend
```

---

# 🧪 Testing

Run the complete test suite:

```bash
mvn test
```

Tests cover areas such as:

```text
✓ DTO Validation

✓ Chat Controller

✓ Service Logic

✓ Mock AI Integration

✓ Error Handling
```

---

# 📸 Screenshots

Add your actual application screenshots here:

<div align="center">

### 💬 Chat Interface

<img src="docs/images/chat.png" width="90%"/>

### 📚 Conversation History

<img src="docs/images/conversations.png" width="90%"/>

### 🔐 Authentication

<img src="docs/images/login.png" width="90%"/>

</div>

---

# 🗺️ Roadmap

```text
                    JAVA AI CHATBOT
                           │
          ┌────────────────┼────────────────┐
          ▼                ▼                ▼

       CURRENT          NEXT             FUTURE

       ✓ Chat           □ JWT            □ Streaming
       ✓ REST API       □ User Profile   □ WebSocket
       ✓ Database       □ Roles          □ File Upload
       ✓ History        □ Security       □ RAG
       ✓ Frontend       □ AI Providers   □ AI Agents
       ✓ Testing
```

---

# 🎯 Learning Goals

This project is also a practical way to strengthen Java development skills.

```text
Java
  ↓
OOP
  ↓
Spring Boot
  ↓
REST APIs
  ↓
JPA / Hibernate
  ↓
Database
  ↓
Security
  ↓
Testing
  ↓
AI Integration
```

> **The goal isn't only to build a chatbot.  
> The goal is to understand how a production-style Java application is designed.**

---

# 📚 Documentation

More detailed documentation is available in:

```text
docs/
│
├── architecture.md
├── api.md
├── learning-guide.md
└── README.md
```

Learning roadmap:

```text
LEARNING.md
```

---

# 🔮 Future Vision

The long-term goal is to evolve this project into a more complete AI platform.

```text
              ┌─────────────────┐
              │    JAVA AI      │
              │     CORE        │
              └────────┬────────┘
                       │
       ┌───────────────┼───────────────┐
       ▼               ▼               ▼
     Chat            RAG            Agents
       │               │               │
       ▼               ▼               ▼
    Memory          Documents       Automation
       │               │               │
       └───────────────┼───────────────┘
                       ▼
                 AI WORKSPACE
```

---

# 👨‍💻 Built By

<div align="center">

## Dipak Sonawane

**Java • AI • Software Development**

I'm using this project to apply my Java knowledge, experiment with AI integration, and learn how full-stack applications are designed and structured.

<br>

<a href="https://github.com/DSnext412-jpg">
<img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github"/>
</a>

<a href="https://www.linkedin.com/">
<img src="https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin"/>
</a>

</div>

---

<div align="center">

# 🤖 JAVA × AI

### Build → Learn → Test → Improve

<br>

<img src="https://capsule-render.vercel.app/api?type=waving&height=120&section=footer&color=gradient"/>

**⭐ If you find this project interesting, consider starring the repository.**

</div>
