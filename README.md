# 📚 Library Management System (DBMS Project)

## 🔷 Project Overview

This project is a **Library Management System** developed using **MySQL (RDBMS)** and **Java (JDBC)**.
It is designed to manage library operations such as maintaining book records, member details, issuing and returning books.

---

## 🎯 Objectives

* Design a relational database for a real-world business application
* Implement CRUD (Create, Read, Update, Delete) operations
* Establish relationships using primary and foreign keys
* Execute SQL queries for data retrieval and reporting
* Integrate database with a Java-based application using JDBC

---

## 🛠️ Technologies Used

* **Database:** MySQL
* **Language:** Java
* **Connectivity:** JDBC (MySQL Connector/J)
* **Tool:** MySQL Workbench

---

## 🗂️ Database Schema

The database consists of the following tables:

* **branch** – Stores branch details
* **employees** – Stores employee information
* **books** – Stores book records
* **members** – Stores library members
* **issued_status** – Tracks issued books
* **return_status** – Tracks returned books

### 🔗 Relationships

* One branch → Many employees
* One member → Many issued books
* One book → Many issue records
* Issued books → Linked to return records

---

## ⚙️ Features

* View all books
* Add new members
* Issue books to members
* View issued book records (using JOIN queries)
* Maintain relational integrity using foreign keys

---

## 🖥️ Java Application (JDBC)

A **menu-driven terminal application** is implemented in Java to interact with the database.

### Menu Options:

1. View Books
2. Add Member
3. Issue Book
4. View Issued Books
5. Exit

---

## 📂 Project Structure

```
LibraryDB/
│
├── LibraryApp.java
├── mysql-connector-j-9.x.x.jar
│
├── sql/
│   ├── table_creation.sql
│   ├── data_insertion.sql
│   ├── data_insertion2.sql
│   ├── Queries_solution.sql
│
├── data/
│   ├── books.csv
│   ├── members.csv
│   ├── employees.csv
│   ├── branch.csv
│   ├── issued_status.csv
│   ├── return_status.csv
```

---

## 🚀 How to Run the Project

### 🔹 Step 1: Setup Database

1. Open MySQL Workbench
2. Create database:

```sql
CREATE DATABASE LibraryDB;
USE LibraryDB;
```

3. Run:

* `table_creation.sql`
* `data_insertion.sql`
* `data_insertion2.sql`

---

### 🔹 Step 2: Setup Java Program

1. Download MySQL Connector/J
2. Place `.jar` file in project folder

---

### 🔹 Step 3: Compile & Run

```bash
javac -cp ".;mysql-connector-j-9.x.x.jar" LibraryApp.java
java -cp ".;mysql-connector-j-9.x.x.jar" LibraryApp
```

---

## 📊 Sample SQL Queries

```sql
-- View all books
SELECT * FROM books;

-- Join query to view issued books
SELECT m.member_name, b.book_title
FROM issued_status i
JOIN members m ON i.issued_member_id = m.member_id
JOIN books b ON i.issued_book_isbn = b.isbn;

-- Count issued books
SELECT COUNT(*) FROM issued_status;
```

---

## 📄 Forms Designed

* Add Member Form
* Add Book Form
* Issue Book Form
* Return Book Form

---

## 📈 Reports Generated

* Issued Books Report
* Member-wise Activity
* Book Availability Status

---

## 🔐 Key Concepts Used

* Relational Database Design
* Primary & Foreign Keys
* Normalization
* SQL Joins
* JDBC Connectivity

---

## 📌 Conclusion

This project demonstrates the implementation of a **relational database system integrated with a Java application** to perform real-world operations efficiently.

---

## 👨‍💻 Author

**Sameer Singh**  
**Mail:** sameer0555singh@gmail.com

---
