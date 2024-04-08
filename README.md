# Bookmark Service Application

This is a simple bookmark service application built using Spring Boot and JPA.

## Overview
The application allows users to manage bookmarks.

## Getting Started

### Prerequisites
- Java JDK 8 or higher
- Maven

### Installation
1. Clone the repository:
```bash
  git clone https://github.com/abhishekshah2905/spring-boot-bookmark.git
```
2. Navigate to the project directory:
```bash
  cd spring-boot-bookmark
```
3. Build the project:
```bash
  mvn clean install
```
4. Run the application:
```bash
  mvn spring-boot:run
```
5. Access the application at http://localhost:9098

### Usage
- Use Swagger UI to interact with the API and manage bookmarks.
- Navigate to http://localhost:9098/swagger-ui.html to access the Swagger UI.

### Features
- Create a new bookmark for a user.
- Retrieve all bookmarks for a user.
- Retrieve a specific bookmark by its ID.