# File Upload Service

File management project using Spring Boot for file download, storage, and metadata retrieval.

## Introduction

This project implements a file upload service using Spring Boot. It allows users to upload files, which are stored on the server's file system. Metadata about each uploaded file is stored in a database for easy retrieval and management.

## Features

- **File Upload:** Allows users to upload files.
- **File Storage:** Stores uploaded files on the server's file system.
- **Metadata Storage:** Stores metadata (such as filename, content type, size, and upload timestamp) in a database.
- **File Retrieval:** Provides endpoints to retrieve files and their metadata.

## Technologies Used

- **Spring Boot:** Application framework used to build the service.
- **Spring Data JPA:** Used for database operations and managing file metadata.
- **Postgresql:** In-memory database used for storing file metadata (can be easily replaced with other databases like MySQL,etc.).
- **Spring Web:** Used for handling HTTP requests.
- **Spring Test:** Used for testing the Spring components.

## Getting Started

To run this project locally, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd file_upload_service
2. **Build the project:**
   ```bash
   ./mvnw clean package
3. **Run the application:**
   ```bash
   java -jar target/file-upload-service-0.0.1-SNAPSHOT.jar
4. **Access the application:**
   ```bash
   Open your web browser and go to http://localhost:8080

## Directory Structure
file_upload_service/
├── src/
│   ├── main/
│   │   ├── java/com/bballbrain/fileuploadservice/
│   │   │   ├── controller/           # Controllers for handling HTTP requests
│   │   │   ├── model/                # Entity classes and database repositories
│   │   │   ├── repository/           # Spring Data JPA repositories
│   │   │   ├── service/              # Service layer implementing business logic
│   │   │   ├── FileUploadServiceApplication.java  # Main Spring Boot application class
│   │   ├── resources/
│   │   │   ├── application.properties  # Application configuration file
│   │   │   ├── static/               # Static resources (e.g., uploaded files)
│   │   │   ├── templates/            # HTML templates (if any)
│   ├── test/
│   │   ├── java/com/bballbrain/fileuploadservice/
│   │   │   ├── controller/           # Unit and integration tests for controllers
│   │   │   ├── service/              # Unit tests for service layer
├── target/                           # Compiled files (auto-generated)
├── upload-dir/                       # Storage directory for uploaded files (auto-generated)
├── mvnw                              # Maven wrapper script for Unix
├── mvnw.cmd                          # Maven wrapper script for Windows
├── pom.xml                           # Project configuration file
└── README.md                         # Project README file

   
  

