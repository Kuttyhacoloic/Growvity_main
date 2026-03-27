# Growvity -- Learning Management System (LMS)

## 📌 Project Overview

Growvity is a Learning Management System (LMS) built to manage online
courses, users, enrollments, communication, notes, and payments. The
system supports role-based access control for Admin, Staff (Trainers),
and Users (Students).

This project demonstrates backend system design using a relational
database structure suitable for integration with Spring Boot and
MariaDB/MySQL.

------------------------------------------------------------------------

## 🏗️ System Architecture (High-Level)

The system follows a layered architecture:

-   Controller Layer -- Handles HTTP requests and API endpoints.
-   Service Layer -- Contains business logic.
-   Repository Layer -- Communicates with the database.
-   Database Layer -- MariaDB relational database.

------------------------------------------------------------------------

## 🗄️ Database Structure

### 1️⃣ Users Table

Stores system users such as ADMIN, STAFF, and USER.

Key Fields: - id (Primary Key) - email (Unique) - full_name - password -
phone - role (ENUM: ADMIN, STAFF, USER) - is_active - created_at

------------------------------------------------------------------------

### 2️⃣ Courses Table

Stores course information.

Key Fields: - id (Primary Key) - title - description - price -
duration - is_published - trainer_id (Foreign Key → users.id) -
created_at

Relationship: - One trainer can create multiple courses.

------------------------------------------------------------------------

### 3️⃣ Enrollments Table

Tracks student enrollments in courses.

Key Fields: - id (Primary Key) - course_id (Foreign Key → courses.id) -
student_id (Foreign Key → users.id) - enrolled_at - status

Relationship: - One student can enroll in multiple courses. - One course
can have multiple students.

------------------------------------------------------------------------

### 4️⃣ Messages Table

Used for internal communication between users.

Key Fields: - id (Primary Key) - sender_id (Foreign Key → users.id) -
receiver_id (Foreign Key → users.id) - subject - message_body -
is_read - sent_at

Relationship: - One user can send and receive multiple messages.

------------------------------------------------------------------------

### 5️⃣ Notes Table

Stores course learning materials.

Key Fields: - id (Primary Key) - course_id (Foreign Key → courses.id) -
uploaded_by (Foreign Key → users.id) - title - file_url - uploaded_at

Relationship: - One course can have multiple notes. - Trainers upload
notes.

------------------------------------------------------------------------

### 6️⃣ Payments Table

Tracks course payment transactions.

Key Fields: - id (Primary Key) - student_id (Foreign Key → users.id) -
course_id (Foreign Key → courses.id) - amount - payment_date -
payment_status - transaction_id - payment_method

Relationship: - One student can make multiple payments. - Each payment
is linked to a course.

------------------------------------------------------------------------

## 🔐 Key Features

-   Role-Based Access Control (RBAC)
-   Course Management
-   Student Enrollment Tracking
-   Secure Payment Tracking
-   Internal Messaging System
-   Notes/Resource Upload System

------------------------------------------------------------------------

## 🚀 Future Enhancements

-   JWT-based authentication
-   Payment gateway integration
-   Course progress tracking
-   Certificate generation
-   REST API documentation (Swagger)
-   Docker deployment support
-   Cloud deployment (AWS)

------------------------------------------------------------------------

## 🧩 Technology Stack

Backend: Spring Boot (Java)\
Database: MariaDB / MySQL\
ORM: JPA / Hibernate\
Build Tool: Maven

------------------------------------------------------------------------

## 📊 UML & Documentation

Refer to the generated UML PDF for detailed database relationships and
structural explanation.

------------------------------------------------------------------------

## 👨‍💻 Author

Project: Growvity LMS\Gowtham S B.tech
Purpose: Academic / Learning Management System Implementation
