# Java AI Chatbot

A full-stack AI chatbot application built with Java, Spring Boot, and HTML/CSS/JavaScript.

## Project Overview

This project demonstrates a complete AI chatbot solution featuring:
- Backend REST API with Spring Boot
- AI API integration using HTTP/JSON
- PostgreSQL database (with H2 for development)
- Conversation history persistence
- Authentication support
- Modern chat frontend

## Features

### Core Features
- **Basic Chat**: Send messages to AI API and receive responses
- **AI API Integration**: Abstracted behind AIService interface for easy replacement
- **Conversation History**: Create, view, and delete multiple conversations
- **Message Storage**: Persistent storage of chat messages with roles (USER/ASSISTANT/SYSTEM)

### Authentication (Planned)
- User registration and login
- Secure password handling
- JWT token support (configuration ready)

### Frontend
- Clean, modern chatbot UI
- Enter to send, Shift+Enter for newline
- Auto-scrolling chat area
- User/AI message distinction
- Loading indicator
- Error message display
- Responsive design

### Error Handling
- Centralized exception handling
- Proper HTTP error codes (400, 401, 403, 404, 429, 500, 503)
- Clean JSON error responses
- No API key exposure

### Testing
- JUnit 5 unit tests
- Spring Boot Test integration
- Mockito for mocking external services
- 4+ test cases covering core functionality

## Technology Stack

### Backend
- **Java 21+** - Modern Java version
- **Spring Boot 3.2.2** - Framework for backend development
- **Spring Web** - REST API endpoints
- **Spring Data JPA** - Database operations
- **Hibernate** - ORM implementation
- **PostgreSQL** - Production database
- **H2 Database** - Development database (in-memory)
- **Jackson** - JSON processing
- **Bean Validation** - Input validation
- **Spring Security** - Authentication and authorization

### Frontend
- **HTML5** - Page structure
- **CSS3** - Styling and layout
- **JavaScript** - Interactivity and API calls

### AI Integration
- **HTTP/JSON** - Communication with AI API
- **RestTemplate** - Spring's HTTP client
- **Configurable AI provider** - Easy to swap AI models

### Build Tools
- **Maven** - Project build and dependency management

## Folder Structure

```
java-ai-chatbot/
├── src/
│   ├── main/
│   │   ├── java/com/example/javaaichatbot/
│   │   │   ├── ai/              # AI service interface and implementation
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data transfer objects
│   │   │   ├── exception/       # Exception handling
│   │   │   ├── model/           # JPA entities (User, Conversation, Message)
│   │   │   ├── repository/      # Database repositories
│   │   │   ├── service/         # Business logic services
│   │   │   ├── security/        # Security configuration
│   │   │   └── util/            # Utility classes
│   │   │   └── JavaAiChatbotApplication.java  # Main application class
│   │   └── resources/
│   │       ├── application.properties  # Configuration
│   │   └── static/              # Frontend (HTML, CSS, JS)
│   └── test/                  # JUnit tests
├── pom.xml                    # Maven project configuration
├── docs/
│   ├── architecture.md         # Detailed architecture documentation
│   ├── api.md                # API endpoint documentation
│   ├── learning-guide.md     # Java concepts learning guide
│   └── README.md             # This file
├── LEARNING.md               # Stage-based learning roadmap
└── target/                    # Compiled build output
```

## Prerequisites

- Java 21 or higher installed
- Maven 3.9.6 or higher
- (Optional) PostgreSQL for production deployment
- (Optional) AI API key for actual AI functionality

## Installation

### 1. Clone the Repository
```bash
git clone <repository-url>
cd java-ai-chatbot
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Set Environment Variables
```bash
export AI_API_URL=http://localhost:8080
export ADMIN_PASSWORD=your_secure_password
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

Or run the packaged JAR:
```bash
java -jar target/java-ai-chatbot-1.0.0.jar
```

The application will start on `http://localhost:8080`

## Environment Variables

| Variable | Default | Description |
|----------|---------|-------------|
| `AI_API_URL` | `http://localhost:8080` | AI API base URL |
| `ADMIN_PASSWORD` | `admin123` | Admin user password |
| `AI_API_KEY` | (required) | AI service API key |

## API Endpoints

### Chat Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/chat` | Send message to AI |
| `GET` | `/api/conversations` | List all conversations |
| `GET` | `/api/conversations/{id}` | Get conversation by ID |
| `GET` | `/api/conversations/{id}/messages` | Get messages for conversation |
| `DELETE` | `/api/conversations/{id}` | Delete conversation |

### Auth Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Register new user |
| `POST` | `/api/auth/login` | Login user |

### Status Codes
- `200 OK` - Successful operation
- `204 No Content` - Delete operation successful
- `400 Bad Request` - Validation failed
- `401 Unauthorized` - Not authenticated
- `404 Not Found` - Resource doesn't exist
- `503 Service Unavailable` - AI service down

## Usage

### Starting the Application
```bash
# Using Maven
mvn spring-boot:run

# Or using the JAR
java -jar target/java-ai-chatbot-1.0.0.jar
```

### Sending Your First Message
```bash
# Using curl
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d "{\"message\": \"Explain Java inheritance\"}"

# Using the frontend
# 1. Open http://localhost:8080 in your browser
# 2. Type a message in the input field
# 3. Press Enter to send
# 4. View the AI's response
```

## Testing

### Run Tests
```bash
mvn test
```

All tests should pass. Tests cover:
- AI service DTO validation
- Chat controller functionality
- No real AI API key required (tests use mock setup)

## Security

- **Never commit API keys** to the repository
- API keys should be stored in environment variables
- Passwords are never stored in plaintext (configured for hashing)
- CORS is configured properly
- Sensitive information is not exposed in error messages

## License

This project is open source and available under the MIT license.

## Learn More

- [Java 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)