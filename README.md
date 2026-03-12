# Trucking Application

A Spring Boot backend application for managing trucking-related operations such as trips, users, drivers, vehicles, and partner/client companies.

## Tech Stack

- **Java 21**
- **Spring Boot 3**
- **PostgreSQL**
- **Maven**
- **Docker**
- **Lombok**

## Prerequisites

Before running the project, make sure you have installed:

- **Java 21**
- **Maven** (or use the Maven Wrapper included in the project)
- **Docker Desktop** (for PostgreSQL container)

## Database Setup

The project uses PostgreSQL via Docker Compose.

### Start PostgreSQL
```bash
docker-compose up -d
```
This starts a PostgreSQL container exposed on port `5432`.


## Running the Application

You can run the application using Maven (or the Maven Wrapper using 'mvnw' instead of 'mvn'):
```bash
mvn spring-boot:run
```

You can also run tests with:
```bash
mvn test
```

## Future Improvements

Some possible next steps for the project:

- Add Swagger / OpenAPI documentation
- Add global exception handling
- Add authentication endpoints
- Add database migration support with Flyway or Liquibase
- Add profile-based configuration for local/dev/prod
- Improve validation and API response models
- Add logging
- Add more unit tests
- Finish general functionality
