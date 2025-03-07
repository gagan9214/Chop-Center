
# Chop Center - Backend Project

## Overview
Chop Center is a backend application built with Spring Boot that provides authentication, authorization, and CRUD operations for managing "NomNoms." The project includes user authentication via JWT, session management, and access control.

## Features
- User authentication and authorization using JWT
- Secure login and signup system
- Users can create, edit, search, and delete "NomNoms"
- Users can edit any NomNom but can only delete their own
- Session management using JWT token
- Implementation of Spring Security and Spring MVC

## What is a NomNom?
A **NomNom** is a card that contains:
- **Name**: Any food item
- **Description**: Details about the food item
- **Date Created**: Timestamp of creation
- **Last Update Date**: Timestamp of the last update

## Technologies Used
- **Spring Boot** - Backend framework
- **Spring Security** - Authentication and authorization
- **JWT (JSON Web Token)** - Secure session management
- **MySQL** - Database for storing user and NomNom data
- **Spring MVC** - Web framework for handling requests

## API Endpoints

### Authentication
- `POST /auth/signup` → Register a new user
- `POST /auth/signin` → Login user
- `GET /auth/userslist` → Retrieve all users

### NomNom Management
- `POST /create` → Create a NomNom
- `PUT /{id}/edit` → Edit a NomNom
- `DELETE /{id}/delete` → Delete own NomNom
- `GET /search` → Search for NomNoms
- `GET /{nomid}` → Get a specific NomNom
- `GET /` → Retrieve all NomNoms

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone <repository_url>
   cd chop-center
   ```
2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/chopcenter
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Security & Authentication
- Uses JWT for authentication
- Implements `AuthenticationManager` and `AuthenticationProvider`
- `SecurityFilterChain` is configured for request filtering

## License
This project is open-source. You can modify and distribute it as needed.

## Contact
For any queries or contributions, feel free to reach out!

