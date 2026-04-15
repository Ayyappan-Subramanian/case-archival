# Automated Database Archival System

## 📌 Overview
The **Automated Database Archival System** is a backend application built using Java and Spring Boot that automatically archives older records from a primary database to a secondary database. It is designed to improve database performance, optimize storage usage, and ensure efficient data lifecycle management using scheduled jobs and transactional processing.

## 🚀 Features
- Automated archival of records based on defined conditions (e.g., age/time)
- Scheduled job-based processing using Spring Scheduler
- Multi-database support (Primary + Archive DB)
- Transaction-safe data migration using Spring Data JPA
- Batch processing for efficient handling of large datasets
- Clean layered architecture (Controller → Service → Repository)
- Data integrity ensured with rollback support on failure
- Logging for monitoring and debugging archival operations

## 🛠️ Tech Stack
- Java 8+
- Spring Boot
- Spring Data JPA (Hibernate)
- SQL
- Maven
- Spring Scheduler (@Scheduled)
- PostgreSQL / MySQL (configurable)

## 🏗️ Architecture
Controller → Service → Repository → Primary Database  
                         ↓  
                Archival Service  
                         ↓  
               Archive Database  

## ⚙️ How It Works
1. Scheduler triggers archival process at configured intervals
2. System identifies records eligible for archival
3. Data is fetched from the primary database
4. Records are validated and moved to the archive database
5. Successfully migrated records are removed/flagged in the primary database
6. Execution logs are generated for tracking and audit purposes

## 🔧 Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/your-username/automated-db-archival.git
```
### 2. Configure the Database Connection
```bash
spring.datasource.primary.url=jdbc:mysql://localhost:3306/primary_db
spring.datasource.archive.url=jdbc:mysql://localhost:3306/archive_db
spring.datasource.username=root
spring.datasource.password=your_password
```
### 3. Build the project
```bash
mvn clean install
```
### 4. Run the application
```bash
mvn spring-boot:run
```

## 🔧 Project Structure
```bash
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── entity/
 ├── config/
 ├── scheduler/
 └── util/
```
 
## 👨‍💻 Author
Ayyappan Subramanian

Software Developer | Java | Spring Boot | Distributed Systems

GitHub: https://github.com/Ayyappan-Subramanian
