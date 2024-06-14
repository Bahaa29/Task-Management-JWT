# Task-Management-JWT
## Requirements
- Java 21
- MySQL
- AWS
- Maven
- JUnit
- JWT
- Spring Data JPA

## Project Structure
├── config
│   ├── SecurityConfig.java
|   ├── JwtAuthenticationFilter
|   ├── JwtTokenProvider
├── controller
│   ├── AuthController.java
│   ├── TaskController.java
├── model
│   ├── Task.java
│   ├── User.java
│   ├── Role.java
│   ├── History.java
│   ├── Notification.java
├── repository
│   ├── TaskRepository.java
│   ├── UserRepository.java
│   ├── RoleRepository.java
│   ├── NotificationRepository.java
├── service
│   ├── AuthService.java
│   ├── TaskService.java
│   ├── EmailService.java
├── schedular
|   ├── TaskScheduler.java
├── specification
|   ├── TaskSpecification.java
|
└── DataLoader.java
└── TaskManagementApplication.java


## Setup Instructions
1. Clone the repository.
2. Configure MySQL in `src/main/resources/application.properties`.
3. Run `mvn clean install`.
4. Execute `mvn spring-boot:run`.

## API Endpoints
- POST /api/auth/login - Authenticate a user
- POST /api/tasks - Create a new task
- GET /api/tasks/{id} - Get a task by ID
- PUT /api/tasks/{id} - Update a task by ID
- DELETE /api/tasks/{id} - Delete a task by ID
- GET /api/tasks - Get all tasks
- GET /api/tasks/search?title=Sample&status=completed&startDate={}:00&endDate={} - Combined Search
- GET /api/tasks/search?status=completed - Search by Status
- GET /api/tasks/search?title={} -Search by Title

## Seed Data
The application initializes with default users and roles:
- Username: admin, Password: admin (Admin Role)
- Username: user, Password: user (User Role)
