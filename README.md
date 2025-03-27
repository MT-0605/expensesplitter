# Expense Splitter

## Overview
Expense Splitter is a backend application designed to manage and split expenses among users efficiently. It provides essential CRUD operations to handle expense records and user balances.

## Features
- User authentication and login system
- CRUD operations for managing expenses
- API endpoints for creating, updating, and deleting expenses,users and expense-share
- User-based expense tracking
- Database integration for persistent storage

## Technologies Used
- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Authentication**: spring security

## Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/MT-0605/expensesplitter.git
   cd expensesplitter
   ```
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Configure the database in `application.properties`.
4. Start the backend server:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
- **POST /api/users - Register a new user
- **GET /api/users/** - Return all users and if specified id then return that user
- **PUT /api/users/{id}** - Update an user
- **DELETE /api/users/{id}** - Delete an user
- **POST /api/expenses** - Add a new expense
- **GET /api/expenses/** - Retrieve all expenses
- **PUT /api/expenses/{id}** - Update an expense
- **DELETE /api/expenses/{id}** - Delete an expense
- **POST /api/expense-shares** - Add expense share
- **GET /api/expense-shares/{id}** - Get the expense share
- **PUT /api/expense-shares/{id}** - Update the expense share
- **DELETE /api/expense-share/{id}** - Delete an expense share

## Contributing
If you’d like to contribute, feel free to fork the repository and submit a pull request with your changes.


## Contact
For any queries or suggestions, feel free to reach out!
Email: meettank652006@gmail.com
GitHub: [MT-0605](https://github.com/MT-0605)

