# TaskFlow API - Task Management REST Service

## Overview

TaskFlow API is a RESTful Task Management application developed using Spring Boot and MySQL. The application provides secure CRUD operations for managing tasks and demonstrates the use of modern Spring technologies including Spring Data JPA, Spring Security, Validation, and HATEOAS.

This project was developed as part of a Java Full Stack assignment to showcase REST API development, database integration, exception handling, and API security.

---

## Features

* Create Tasks
* View All Tasks
* View Task by ID
* Update Existing Tasks
* Delete Tasks
* Input Validation
* Global Exception Handling
* Spring Security Authentication
* HATEOAS Support
* MySQL Database Integration
* RESTful API Architecture

---

## Technology Stack

### Backend

* Java 21
* Spring Boot 3.5.3
* Spring Data JPA
* Spring Security
* Hibernate ORM

### Database

* MySQL 8

### Build Tool

* Maven

### Additional Libraries

* HATEOAS
* Jakarta Validation
* HikariCP Connection Pool

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.contactmanager
│   │       ├── config
│   │       ├── controller
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       └── service
│   └── resources
│       └── application.properties
└── test
```

---

## Database Configuration

Create the database:

```sql
CREATE DATABASE taskflowdb;
```

Update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflowdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

---

## Running the Application

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project:

```bash
cd Java_FullStack_Web_Task4
```

Run the application:

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

---

## API Endpoints

| Method | Endpoint        | Description         |
| ------ | --------------- | ------------------- |
| GET    | /api/tasks      | Retrieve all tasks  |
| GET    | /api/tasks/{id} | Retrieve task by ID |
| POST   | /api/tasks      | Create a new task   |
| PUT    | /api/tasks/{id} | Update task         |
| DELETE | /api/tasks/{id} | Delete task         |

---

## Authentication

Basic Authentication is enabled.

Example credentials:

```text
Username: admin
Password: secret
```

---

## Sample Request

```json
{
  "title": "Learn Spring Boot",
  "description": "Complete Task 4 Assignment",
  "dueDate": "2026-06-30",
  "status": "PENDING"
}
```

---

## Learning Outcomes

* REST API Development
* Spring Boot Fundamentals
* Database Integration with JPA
* Spring Security Implementation
* Exception Handling
* Validation Techniques
* HATEOAS Integration
* Maven Project Management

---

## Author

Navaroop Amjuri
