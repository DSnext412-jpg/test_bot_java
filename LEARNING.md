# Learning Roadmap - Java AI Chatbot

This project is divided into stages for systematic learning. Complete each stage before moving to the next.

## Stage 1: Core Java
**What I need to learn:**
- Object-Oriented Programming fundamentals
- Classes, objects, inheritance, polymorphism
- Exception handling and generics
- Collections Framework (List, Map, Set)

**Files demonstrating it:**
- `src/main/java/com/example/javaaichatbot/model/User.java`
- `src/main/java/com/example/javaaichatbot/model/Conversation.java`
- `src/main/java/com/example/javaaichatbot/model/Message.java`
- `src/main/java/com/example/javaaichatbot/exception/AIServiceException.java`

**Concept meaning:**
- **Classes and Objects**: Blueprints for creating data structures that represent real-world entities (users, conversations, messages)
- **Inheritance**: Message has an enum Role that extends behavior
- **Encapsulation**: Data is hidden inside classes with public getters/setters
- **Exceptions**: Error handling when things go wrong (AI API down, validation failed)

**Small exercises:**
1. Create a new model class `SystemPrompt` with fields `name` and `content`
2. Create a custom exception `ValidationException` for input validation
3. Write a simple Java program that uses a List of Messages and prints them

**Before moving forward, I should be able to explain:**
- How classes relate to each other (has-a, is-a relationships)
- How exception propagation works in the call stack
- Why we use getters/setters instead of public fields

---

## Stage 2: Maven
**What I need to learn:**
- Project Object Model (POM) structure
- Dependencies management
- Build lifecycle (compile, test, package, install)
- Maven coordinates (groupId, artifactId, version)

**Files demonstrating it:**
- `pom.xml` - Project configuration file

**Concept meaning:**
- **POM**: The heart of any Maven project, contains project configuration and dependencies
- **Dependencies**: Libraries your project needs (Spring Boot, PostgreSQL, etc.)
- **Lifecycle**: Phases like compile, test, package that Maven executes in order

**Small exercises:**
1. Add a new dependency to pom.xml (e.g., Lombok for reducing boilerplate)
2. Run `mvn clean compile` to verify compilation
3. Run `mvn test` to execute tests
4. Add a new Maven profile for different environments

**Before moving forward, I should be able to explain:**
- What is the difference between `<scope>compile</scope>` and `<scope>test</scope>`
- How Maven resolves dependency versions
- What is the parent POM and why we use it (spring-boot-starter-parent)

---

## Stage 3: HTTP
**What I need to learn:**
- HTTP methods (GET, POST, PUT, DELETE)
- Request/Response cycle
- Status codes (200, 404, 500, etc.)
- Headers (Content-Type, Authorization)
- JSON format for data exchange
- RESTful API design principles

**Files demonstrating it:**
- `AIServiceImpl.java` - HTTP client using RestTemplate
- `ChatController.java` - REST endpoint definitions

**Concept meaning:**
- **REST**: Representational State Transfer - architectural style for distributed systems
- **HTTP Methods**: GET (read), POST (create), PUT (update), DELETE (remove)
- **JSON**: JavaScript Object Notation - lightweight data interchange format
- **RestTemplate**: Spring's synchronous HTTP client for making REST calls

**Small exercises:**
1. Use curl or Postman to test your API endpoints
2. Change the AI API URL in application.properties and observe behavior
3. Add a new endpoint to the controller (e.g., GET /api/health)
4. Test different HTTP status codes

**Before moving forward, I should be able to explain:**
- What makes an API "RESTful"
- Difference between GET (safe, idempotent) and POST (not safe)
- How JSON maps to Java objects

---

## Stage 4: JSON
**What I need to learn:**
- JSON structure (objects, arrays, key-value pairs)
- Jackson library for JSON processing
- Serialization (Java object -> JSON)
- Deserialization (JSON -> Java object)
- ObjectMapper configuration

**Files demonstrating it:**
- `ChatRequest.java` and `ChatResponse.java` - DTO classes
- `AIServiceImpl.java` - JSON request/response handling

**Concept meaning:**
- **Serialization**: Converting a Java object to JSON string
- **Deserialization**: Converting JSON string to Java object
- **Jackson**: Spring Boot's default JSON processing library
- **DTOs**: Data Transfer Objects that move data between layers

**Small exercises:**
1. Add a new field to ChatRequest and verify it appears in JSON
2. Create a new DTO for registration request
3. Use ObjectMapper directly to serialize/deserialize custom objects

**Before moving forward, I should be able to explain:**
- How annotation `@JsonProperty` works
- Difference between `@JsonIgnore` and `transient`
- How to handle null values in JSON

---

## Stage 5: AI API
**What I need to learn:**
- External API integration
- HTTP request/response cycle
- API keys and authentication
- Rate limiting handling
- Error handling for external services

**Files demonstrating it:**
- `AIService.java` - Interface for AI service
- `AIServiceImpl.java` - Implementation using RestTemplate
- `AIConfig.java` - Configuration class

**Concept meaning:**
- **API Integration**: How your application communicates with external services
- **Environment Variables**: Keeping API keys secure (never hardcode!)
- **Timeouts**: How long to wait before giving up
- **Rate Limits**: How many requests per time period are allowed

**Small exercises:**
1. Add a new AI model configuration (e.g., gpt-4)
2. Implement timeout handling (currently 30 seconds)
3. Add retry logic for failed API calls
4. Create a mock AI service for testing without real API key

**Before moving forward, I should be able to explain:**
- Why we use `System.getenv()` instead of hardcoding keys
- How to handle different AI API response formats
- What to do when the API returns an error

---

## Stage 6: Spring Boot
**What I need to learn:**
- Spring Boot fundamentals
- Auto-configuration
- Embedded servers (Tomcat)
- Starters (spring-boot-starter-web, spring-boot-starter-data-jpa)
- Application entry point

**Files demonstrating it:**
- `JavaAiChatbotApplication.java` - Main Spring Boot application
- `pom.xml` - Spring Boot starter parent
- `application.properties` - Configuration file

**Concept meaning:**
- **Spring Boot**: Framework that simplifies Spring application development
- **Auto-configuration**: Automatic Spring configuration based on dependencies
- **Starters**: Convenient dependency groups (spring-boot-starter-web includes Tomcat, Spring MVC, etc.)
- **Embedded Server**: Tomcat runs inside Java, no external server needed

**Small exercises:**
1. Add a new Spring Boot starter dependency
2. Change server port in application.properties
3. Add a new `@Configuration` class
4. Run `mvn spring-boot:run` to start the application

**Before moving forward, I should be able to explain:**
- What `@SpringBootApplication` annotates (main class, component scan, auto-configuration)
- How auto-configuration auto-datasources work
- Difference between `application.properties` and `application.yml`

---

## Stage 7: REST API
**What I need to learn:**
- REST API design
- Resource URLs
- HTTP methods on resources
- Request parameters
- Response formats
- Versioning

**Files demonstrating it:**
- `ChatController.java` - REST controller with endpoints
- `SecurityConfig.java` - Security configuration

**Concept meaning:**
- **Resource**: A piece of data (user, conversation, message) identified by URL
- **Stateless**: Each request contains all information needed (no server-side sessions)
- **HTTP Methods**: Standard methods for CRUD operations

**Small exercises:**
1. Add versioning to your API (/api/v1/chat vs /api/v2/chat)
2. Add query parameters to GET endpoints
3. Implement proper HTTP status codes for each scenario
4. Add Swagger/OpenAPI documentation

**Before moving forward, I should be able to explain:**
- URL structure best practices
- When to use path parameters vs query parameters
- Importance of consistent error responses

---

## Stage 8: PostgreSQL + JPA
**What I need to learn:**
- Relational databases
- SQL basics (SELECT, INSERT, UPDATE, DELETE)
- JPA (Java Persistence API) for database operations
- Hibernate as JPA implementation
- Entity relationships (One-to-Many, Many-to-One)

**Files demonstrating it:**
- `User.java`, `Conversation.java`, `Message.java` - JPA entities
- `UserRepository.java`, `ConversationRepository.java`, `MessageRepository.java` - Repositories
- `application.properties` - Database configuration

**Concept meaning:**
- **Entity**: A Java class mapped to a database table
- **Repository**: Interface for CRUD operations on entities
- **JPA**: Standard Java API for database access
- **Hibernate**: Most popular JPA implementation
- **Relationships**: How tables connect (user has many conversations)

**Small exercises:**
1. Add a new entity (e.g., `SystemPrompt`) with relationship to User
2. Add a custom query method to a repository
3. Run `mvn spring-boot:run` and observe database table creation
4. Write raw SQL queries using `@Query` annotation

**Before moving forward, I should be able to explain:**
- Difference between `@OneToOne`, `@OneToMany`, `@ManyToOne`
- What `spring.jpa.hibernate.ddl-auto=update` does
- How foreign keys work in JPA

---

## Stage 9: Authentication
**What I need to learn:**
- User authentication concepts
- Password hashing (never store plaintext!)
- Spring Security configuration
- Form login vs JWT tokens
- Security filter chain

**Files demonstrating it:**
- `SecurityConfig.java` - Security configuration
- `UserRepository.java` - User lookup methods

**Concept meaning:**
- **Authentication**: Verifying who the user is (login)
- **Authorization**: What the user is allowed to do
- **Password Hashing**: Converting passwords to irreversible strings
- **Security Filter Chain**: Intercepting every request to check authentication

**Small exercises:**
1. Add password validation (min length, complexity)
2. Add @PreAuthorize annotations to restrict method access
3. Test login with correct/incorrect credentials
4. Add CSRF configuration

**Before moving forward, I should be able to explain:**
- Why we never store plaintext passwords
- Difference between authentication and authorization
- How Spring Security's filter chain works

---

## Stage 10: Frontend
**What I need to learn:**
- HTML structure
- CSS styling
- JavaScript DOM manipulation
- Fetch API for HTTP requests
- Event handling
- User experience design

**Files demonstrating it:**
- `static/index.html` - Chatbot frontend
- CSS styles in the HTML file

**Concept meaning:**
- **HTML**: Structure of web pages
- **CSS**: Styling and layout
- **JavaScript**: Adding interactivity to web pages
- **Fetch API**: Making HTTP requests from frontend JavaScript

**Small exercises:**
1. Add a new page (e.g., settings page)
2. Add local storage to remember conversation names
3. Add loading spinner during AI response
4. Improve mobile responsiveness

**Before moving forward, I should be able to explain:**
- How HTML, CSS, and JavaScript work together
- Difference between `innerHTML` and `textContent`
- How to handle async HTTP requests with fetch()

---

## Stage 11: Testing
**What I need to learn:**
- JUnit 5 testing framework
- Spring Boot Test integration
- Mockito for mocking dependencies
- Test assertions
- Test lifecycle (@BeforeEach, @AfterEach)

**Files demonstrating it:**
- `AIServiceTest.java` and `ChatControllerTest.java` - Test classes
- Mockito usage in tests

**Concept meaning:**
- **Unit Test**: Testing individual components in isolation
- **Mockito**: Creating mock objects for dependencies
- **Assertion**: Verifying expected vs actual results
- **Test Isolation**: Tests shouldn't depend on each other

**Small exercises:**
1. Add a test that verifies validation rejects empty messages
2. Write a test that mocks the AI API
3. Add @BeforeEach to set up test fixtures
4. Test error handling scenarios

**Before moving forward, I should be able to explain:**
- Why we test without real API keys (mocking)
- Difference between unit and integration tests
- What "code coverage" means

---

## Stage 12: Deployment
**What I need to learn:**
- Docker containerization
- Cloud deployment (AWS, Azure, Heroku)
- Production configuration
- Database migration
- Monitoring and logging

**Files demonstrating it:**
- Dockerfile (to be created)
- Production application.properties
- Deployment scripts

**Small exercises:**
1. Create a Dockerfile for the application
2. Deploy to a cloud platform
3. Set up PostgreSQL production database
4. Add monitoring/logging configuration

**Before moving forward, I should be able to explain:**
- How Docker containers work
- Difference between development and production configurations
- Basic cloud deployment steps

---

## Complete Project Status

**Milestones Completed:**
- [x] Stage 1: Core Java - Model classes, exceptions
- [x] Stage 2: Maven - Project setup, dependencies
- [x] Stage 3: HTTP - REST endpoints, AI API integration
- [x] Stage 4: JSON - DTOs, request/response handling
- [x] Stage 5: AI API - Abstracted AI service integration
- [x] Stage 6: Spring Boot - Main application, configuration
- [x] Stage 7: REST API - Endpoint design, security
- [x] Stage 8: PostgreSQL + JPA - Entities, repositories, relationships
- [x] Stage 9: Authentication - Security configuration
- [x] Stage 10: Frontend - Chatbot UI, HTML/CSS/JS
- [x] Stage 11: Testing - JUnit tests, Mockito mocking
- [ ] Stage 12: Deployment - Docker, cloud deployment (pending)

**Current Focus:** Stage 12: Deployment

**Next Milestone:** Deploy the application to production with PostgreSQL database