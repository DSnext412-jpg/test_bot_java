# Learning Guide - Java AI Chatbot Project

This guide explains the Java concepts used in this project, perfect for learning backend development, APIs, JSON, Spring Boot, databases, and AI integration.

## Stage 1: Core Java

### What You Need to Learn
- Object-Oriented Programming (classes, objects, inheritance, polymorphism)
- Exception handling (try-catch, custom exceptions)
- Collections Framework (List, Map, Set)
- Generics
- Streams and Lambdas

### Files Demonstrating This
- `Model.java` classes (User, Conversation, Message) - OOP concepts
- Custom exceptions (`AIServiceException.java`) - exception handling

### Concept Meaning
- **Classes and Objects**: Blueprints for creating data structures that represent real-world entities (users, conversations, messages)
- **Inheritance**: Message has an enum Role that extends behavior
- **Encapsulation**: Data is hidden inside classes with public getters/setters
- **Exceptions**: Error handling when things go wrong (AI API down, validation failed)

### Exercises
1. Create a new model class `SystemPrompt` with fields `name` and `content`
2. Create a custom exception `ValidationException` for input validation
3. Write a simple Java program that uses a List of Messages and prints them

### What You Should Explain Before Moving Forward
- How classes relate to each other (has-a, is-a relationships)
- How exception propagation works in the call stack
- Why we use getters/setters instead of public fields

---

## Stage 2: Maven

### What You Need to Learn
- Project Object Model (POM) structure
- Dependencies management
- Build lifecycle (compile, test, package, install)
- Maven coordinates (groupId, artifactId, version)
- Profiles and properties

### Files Demonstrating This
- `pom.xml` - Project configuration file

### Concept Meaning
- **POM**: The heart of any Maven project, contains project configuration and dependencies
- **Dependencies**: Libraries your project needs (Spring Boot, PostgreSQL, etc.)
- **Lifecycle**: Phases like compile, test, package that Maven executes in order

### Exercises
1. Add a new dependency to pom.xml (e.g., Lombok for reducing boilerplate)
2. Run `mvn clean compile` to verify compilation
3. Run `mvn test` to execute tests
4. Add a new Maven profile for different environments

### What You Should Explain Before Moving Forward
- What is the difference between `<scope>compile</scope>` and `<scope>test</scope>`
- How Maven resolves dependency versions
- What is the parent POM and why we use it (spring-boot-starter-parent)

---

## Stage 3: HTTP

### What You Need to Learn
- HTTP methods (GET, POST, PUT, DELETE)
- Request/Response cycle
- Status codes (200, 404, 500, etc.)
- Headers (Content-Type, Authorization)
- JSON format for data exchange
- RESTful API design principles

### Files Demonstrating This
- `AIServiceImpl.java` - HTTP client using RestTemplate
- `ChatController.java` - REST endpoint definitions

### Concept Meaning
- **REST**: Representational State Transfer - architectural style for distributed systems
- **HTTP Methods**: GET (read), POST (create), PUT (update), DELETE (remove)
- **JSON**: JavaScript Object Notation - lightweight data interchange format
- **RestTemplate**: Spring's synchronous HTTP client for making REST calls

### Exercises
1. Use curl or Postman to test your API endpoints
2. Change the AI API URL in application.properties and observe behavior
3. Add a new endpoint to the controller (e.g., GET /api/health)
4. Test different HTTP status codes

### What You Should Explain Before Moving Forward
- What makes an API "RESTful"
- Difference between GET (safe, idempotent) and POST (not safe)
- How JSON maps to Java objects

---

## Stage 4: JSON

### What You Need to Learn
- JSON structure (objects, arrays, key-value pairs)
- Jackson library for JSON processing
- Serialization (Java object -> JSON)
- Deserialization (JSON -> Java object)
- ObjectMapper configuration

### Files Demonstrating This
- `ChatRequest.java` and `ChatResponse.java` - DTO classes
- `AIServiceImpl.java` - JSON request/response handling

### Concept Meaning
- **Serialization**: Converting a Java object to JSON string
- **Deserialization**: Converting JSON string to Java object
- **Jackson**: Spring Boot's default JSON processing library
- **DTOs**: Data Transfer Objects that move data between layers

### Exercises
1. Add a new field to ChatRequest and verify it appears in JSON
2. Create a new DTO for registration request
3. Use ObjectMapper directly to serialize/deserialize custom objects

### What You Should Explain Before Moving Forward
- How annotation `@JsonProperty` works
- Difference between `@JsonIgnore` and `transient`
- How to handle null values in JSON

---

## Stage 5: AI API

### What You Need to Learn
- External API integration
- HTTP request/response cycle
- API keys and authentication
- Rate limiting handling
- Error handling for external services

### Files Demonstrating This
- `AIService.java` - Interface for AI service
- `AIServiceImpl.java` - Implementation using RestTemplate
- `AIConfig.java` - Configuration class

### Concept Meaning
- **API Integration**: How your application communicates with external services
- **Environment Variables**: Keeping API keys secure (never hardcode!)
- **Timeouts**: How long to wait before giving up
- **Rate Limits**: How many requests per time period are allowed

### Exercises
1. Add a new AI model configuration (e.g., gpt-4)
2. Implement timeout handling (currently 30 seconds)
3. Add retry logic for failed API calls
4. Create a mock AI service for testing without real API key

### What You Should Explain Before Moving Forward
- Why we use `System.getenv()` instead of hardcoding keys
- How to handle different AI API response formats
- What to do when the API returns an error

---

## Stage 6: Spring Boot

### What You Need to Learn
- Spring Boot fundamentals
- Auto-configuration
- Embedded servers (Tomcat)
- Starters (spring-boot-starter-web, spring-boot-starter-data-jpa)
- Application entry point

### Files Demonstrating This
- `JavaAiChatbotApplication.java` - Main Spring Boot application
- `pom.xml` - Spring Boot starter parent
- `application.properties` - Configuration file

### Concept Meaning
- **Spring Boot**: Framework that simplifies Spring application development
- **Auto-configuration**: Automatic Spring configuration based on dependencies
- **Starters**: Convenient dependency groups (spring-boot-starter-web includes Tomcat, Spring MVC, etc.)
- **Embedded Server**: Tomcat runs inside Java, no external server needed

### Exercises
1. Add a new Spring Boot starter dependency
2. Change server port in application.properties
3. Add a new `@Configuration` class
4. Run `mvn spring-boot:run` to start the application

### What You Should Explain Before Moving Forward
- What `@SpringBootApplication` annotates (main class, component scan, auto-configuration)
- How auto-configuration auto-datasources work
- Difference between `application.properties` and `application.yml`

---

## Stage 7: REST API

### What You Need to Learn
- REST API design
- Resource URLs
- HTTP methods on resources
- Request parameters
- Response formats
- Versioning

### Files Demonstrating This
- `ChatController.java` - REST controller with endpoints
- `SecurityConfig.java` - Security configuration

### Concept Meaning
- **Resource**: A piece of data (user, conversation, message) identified by URL
- **Stateless**: Each request contains all information needed (no server-side sessions)
- **HTTP Methods**: Standard methods for CRUD operations

### Exercises
1. Add versioning to your API (/api/v1/chat vs /api/v2/chat)
2. Add query parameters to GET endpoints
3. Implement proper HTTP status codes for each scenario
4. Add Swagger/OpenAPI documentation

### What You Should Explain Before Moving Forward
- URL structure best practices
- When to use path parameters vs query parameters
- Importance of consistent error responses

---

## Stage 8: PostgreSQL + JPA

### What You Need to Learn
- Relational databases
- SQL basics (SELECT, INSERT, UPDATE, DELETE)
- JPA (Java Persistence API) for database operations
- Hibernate as JPA implementation
- Entity relationships (One-to-Many, Many-to-One)

### Files Demonstrating This
- `User.java`, `Conversation.java`, `Message.java` - JPA entities
- `UserRepository.java`, `ConversationRepository.java`, `MessageRepository.java` - Repositories
- `application.properties` - Database configuration

### Concept Meaning
- **Entity**: A Java class mapped to a database table
- **Repository**: Interface for CRUD operations on entities
- **JPA**: Standard Java API for database access
- **Hibernate**: Most popular JPA implementation
- **Relationships**: How tables connect (user has many conversations)

### Exercises
1. Add a new entity (e.g., `SystemPrompt`) with relationship to User
2. Add a custom query method to a repository
3. Run `mvn spring-boot:run` and observe database table creation
4. Write raw SQL queries using `@Query` annotation

### What You Should Explain Before Moving Forward
- Difference between `@OneToOne`, `@OneToMany`, `@ManyToOne`
- What `spring.jpa.hibernate.ddl-auto=update` does
- How foreign keys work in JPA

---

## Stage 9: Authentication

### What You Need to Learn
- User authentication concepts
- Password hashing (never store plaintext!)
- Spring Security configuration
- Form login vs JWT tokens
- Security filter chain

### Files Demonstrating This
- `SecurityConfig.java` - Security configuration
- `UserRepository.java` - User lookup methods

### Concept Meaning
- **Authentication**: Verifying who the user is (login)
- **Authorization**: What the user is allowed to do
- **Password Hashing**: Converting passwords to irreversible strings
- **Security Filter Chain**: Intercepting every request to check authentication

### Exercises
1. Add password validation (min length, complexity)
2. Add @PreAuthorize annotations to restrict method access
3. Test login with correct/incorrect credentials
4. Add CSRF configuration

### What You Should Explain Before Moving Forward
- Why we never store plaintext passwords
- Difference between authentication and authorization
- How Spring Security's filter chain works

---

## Stage 10: Frontend

### What You Need to Learn
- HTML structure
- CSS styling
- JavaScript DOM manipulation
- Fetch API for HTTP requests
- Event handling
- User experience design

### Files Demonstrating This
- `static/index.html` - Chatbot frontend
- CSS styles in the HTML file

### Concept Meaning
- **HTML**: Structure of web pages
- **CSS**: Styling and layout
- **JavaScript**: Adding interactivity to web pages
- **Fetch API**: Making HTTP requests from frontend JavaScript

### Exercises
1. Add a new page (e.g., settings page)
2. Add local storage to remember conversation names
3. Add loading spinner during AI response
4. Improve mobile responsiveness

### What You Should Explain Before Moving Forward
- How HTML, CSS, and JavaScript work together
- Difference between `innerHTML` and `textContent`
- How to handle async HTTP requests with fetch()

---

## Stage 11: Testing

### What You Need to Learn
- JUnit 5 testing framework
- Spring Boot Test integration
- Mockito for mocking dependencies
- Test assertions
- Test lifecycle (@BeforeEach, @AfterEach)

### Files Demonstrating This
- `AIServiceTest.java` and `ChatControllerTest.java` - Test classes
- Mockito usage in tests

### Concept Meaning
- **Unit Test**: Testing individual components in isolation
- **Mockito**: Creating mock objects for dependencies
- **Assertion**: Verifying expected vs actual results
- **Test Isolation**: Tests shouldn't depend on each other

### Exercises
1. Add a test that verifies validation rejects empty messages
2. Write a test that mocks the AI API
3. Add @BeforeEach to set up test fixtures
4. Test error handling scenarios

### What You Should Explain Before Moving Forward
- Why we test without real API keys (mocking)
- Difference between unit and integration tests
- What "code coverage" means

---

## Summary - What You've Learned

Through this project, you've gained hands-on experience with:

1. **Java Fundamentals**: OOP, collections, exceptions, generics
2. **Build Tools**: Maven project management and dependencies
3. **HTTP & REST**: API design, status codes, JSON exchange
4. **JSON Processing**: Serialization/deserialization with Jackson
5. **AI Integration**: External API communication with HTTP/JSON
6. **Spring Boot**: Framework for rapid Java application development
7. **Database**: JPA/Hibernate for PostgreSQL operations
8. **Authentication**: Spring Security for user management
9. **Frontend**: HTML/CSS/JavaScript for user interfaces
10. **Testing**: JUnit + Mockito for reliable code verification

Each stage built upon the previous one, creating a complete full-stack application from database to frontend!

## Next Steps

To continue your learning journey:
1. **Connect to real PostgreSQL** instead of H2 database
2. **Implement JWT authentication** for token-based security
3. **Add a real AI API key** and test with actual AI models
4. **Add more features**: user profiles, message history, search
5. **Learn Docker** for container deployment
6. **Explore Cloud deployment** (AWS, Azure, Heroku)
7. **Study Design Patterns** (Repository, Service, Factory patterns)