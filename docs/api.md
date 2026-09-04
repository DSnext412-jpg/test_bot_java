# API Documentation

## Base URL
`http://localhost:8080/api`

## Authentication

### Register
```
POST /api/auth/register
```
Register a new user.

**Request:**
```json
{
    "username": "john_doe",
    "email": "john@example.com",
    "password": "securepassword123"
}
```

**Response:** `200 OK` with user details

### Login
```
POST /api/auth/login
```
Authenticate user and receive authentication.

**Request:**
```json
{
    "username": "john_doe",
    "password": "securepassword123"
}
```

**Response:** `200 OK` with success message

## Chat Endpoints

### Send Message
```
POST /api/chat
```
Send a message to the AI and get a response.

**Request:**
```json
{
    "message": "Explain Java inheritance"
}
```

**Response:**
```json
{
    "response": "Java inheritance allows a class to acquire the properties and methods of another class."
}
```

**Status Codes:**
- `200 OK`: Successful response
- `400 Bad Request`: Empty or too long message
- `503 Service Unavailable`: AI service temporarily unavailable

### Get Conversations
```
GET /api/conversations
```
Get all conversations for the authenticated user.

**Response:** Array of conversation objects

**Status Codes:**
- `200 OK`: Successfully retrieved conversations
- `401 Unauthorized`: Not authenticated

### Get Conversation
```
GET /api/conversations/{id}
```
Get a specific conversation by ID.

**URL Parameters:**
- `id`: Conversation ID

**Response:** Conversation object with messages

**Status Codes:**
- `200 OK`: Successfully retrieved conversation
- `404 Not Found`: Conversation not found

### Delete Conversation
```
DELETE /api/conversations/{id}
```
Delete a conversation and all its messages.

**URL Parameters:**
- `id`: Conversation ID

**Response:** `204 No Content`

**Status Codes:**
- `204 No Content`: Successfully deleted
- `404 Not Found`: Conversation not found

## Error Response Format

All errors return JSON in this format:
```json
{
    "error": "Error description",
    "status": 400,
    "timestamp": "2024-01-15T10:30:00.000+00:00"
}
```

### Common Error Codes
- `400`: Bad Request (validation failed)
- `401`: Unauthorized (not logged in)
- `403`: Forbidden (access denied)
- `404`: Not Found (resource doesn't exist)
- `429`: Too Many Requests (rate limited)
- `500`: Internal Server Error
- `503`: Service Unavailable (AI API down)