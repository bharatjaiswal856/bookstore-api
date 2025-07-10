# RESTful Bookstore API

This is a Spring Boot project that provides a RESTful API for managing books and authors.

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 In-Memory Database
- Maven

## How to Run
1. Clone the repository.
2. Navigate to the project directory.
3. Run the application using Maven: `mvn spring-boot:run`
4. The application will start on `http://localhost:8080`.

## API Documentation
Once the application is running, you can access the Swagger UI for interactive API documentation at:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Database Console
You can access the H2 in-memory database console at:
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)
**JDBC URL:** `jdbc:h2:mem:bookstoredb`
**User Name:** `sa`
**Password:** `password`