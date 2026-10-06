## Repository Description

> **A beginner-friendly Spring Boot backend project built to understand the fundamentals of backend development, REST APIs, CRUD operations, service-layer business logic, and database interaction using Spring Boot, Spring Data JPA, and MySQL.**
>
> This project is **purely backend-focused** — there is no frontend/UI. It is designed especially for beginners who are starting with Spring Boot and want to understand how a backend application works from receiving an HTTP request to processing data and storing/retrieving it from a database.

### What This Project Covers ? 

- Spring Boot project structure
- REST API development
- HTTP methods:
  - `GET`
  - `POST`
  - `PUT`
  - `DELETE`
- CRUD operations
- Controller → Service → Repository architecture
- Request and Response handling
- JSON data handling
- `@RestController`
- `@RequestMapping`
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@RequestBody`
- `@PathVariable`
- `ResponseEntity`
- HTTP status codes
- Spring Data JPA
- Repository operations
- Entity classes
- `Optional`
- MySQL database interaction
- Testing APIs using tools such as **Apidog/Postman**

### 🧠 Beginner Notes

The main purpose of this project is **learning how the backend works**, rather than building a production-level application.

A typical request follows this flow:
```
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```

For example, when a client sends:
```
POST /api/students/create
```

with JSON data:
```
{
  "name": "Meet",
  "age": 20,
  "email": "meet@gmail.com"
}
```

the request is received by the **Controller**, passed to the **Service**, and then the **Repository** communicates with the database.

The response then travels back:
```
Database
   ↓
Repository
   ↓
Service
   ↓
Controller
   ↓
Client
```

### 📌 Important Note

This project is intentionally kept **simple and beginner-friendly**. The goal is to understand the fundamental concepts of Spring Boot and backend development before moving on to more advanced topics such as:

- Authentication & Authorization
- JWT
- Exception Handling
- DTOs
- Validation
- Global Exception Handling
- Spring Security
- Microservices
- Docker
- Production deployment

### 🛠️ Tech Stack
```
Java
Spring Boot
Spring Data JPA
MySQL
Maven
REST APIs
Apidog / Postman
```

### 🎯 Who Is This For?

This project is suitable for:

- Spring Boot beginners
- Java developers learning backend development
- Students learning REST APIs
- Anyone wanting to understand CRUD operations
- Anyone wanting to understand the Controller-Service-Repository architecture

### ⭐ Learning Goal

> **Don't just copy the code — follow the request flow and understand what happens at every layer.**

Once you understand this project, you'll have a solid foundation for building larger Spring Boot backend applications.  
