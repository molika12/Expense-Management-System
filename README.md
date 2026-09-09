Expense Management System

A secure REST API-based Expense Management System built using Java and Spring Boot.

The application allows users to manage their income, expenses, categories, and monthly budgets. It also provides transaction filtering, expense summaries, and budget-vs-expense analysis.

 Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- JWT Authentication
- Maven
- Postman

Features

 Authentication & Security
- User registration
- User login
- JWT-based authentication
- Password encryption using BCrypt
- Protected REST APIs
- User-specific transaction and budget access

 User Management
- Create user
- Get user details
- Update name
- Update email
- Update password
- Delete user

Category Management
- Create category
- Get all categories
- Get category by ID
- Update category
- Delete category

Transaction Management
- Add income or expense
- Get transactions
- Get transaction by ID
- Update transaction amount
- Update transaction type
- Update description
- Update date
- Update category
- Delete transaction

Transaction Filtering
Transactions can be filtered using:
- Type
- Category
- Start date
- End date
- Multiple filters together

Example:
GET /expence-management/transition?type=Expense


Expense Summary
The application calculates:
- Total income
- Total expense
- Current balance

Example:
{
    "totalIncome": 1000.0,
    "totalExpense": 500.0,
    "balance": 500.0
}


 Budget Management
Users can:
- Create monthly budgets
- View budgets
- Get budget by ID
- Update budget amount
- Update month
- Update year
- Delete budget

 Budget vs Expense
The application compares the monthly budget with actual expenses and calculates:
- Budget
- Total expense
- Remaining budget
- Whether the budget has been exceeded

Example:
```json
{
    "budget": 5000.0,
    "totalExpense": 1500.0,
    "remainingBudget": 3500.0,
    "budgetExceeded": false
}
```

 Database Structure

The application uses MySQL.

Main tables:
User
Category
Transaction
Budget


Relationships:

User
 ├── Transactions
 └── Budgets

Category
 └── Transactions


A transaction belongs to one user and one category.
A budget belongs to one user.

API Endpoints

Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/login` | Login and generate JWT |

 User

| Method | Endpoint | Description |
|---|---|---|
| POST | `/expence-management/user` | Register user |
| GET | `/expence-management/user` | Get all users |
| GET | `/expence-management/user/{id}` | Get user |
| PUT | `/expence-management/user/{id}/name` | Update name |
| PUT | `/expence-management/user/{id}/email` | Update email |
| PUT | `/expence-management/user/{id}/password` | Update password |
| DELETE | `/expence-management/user/{id}` | Delete user |

 Category

| Method | Endpoint | Description |
|---|---|---|
| POST | `/expence-management/category` | Create category |
| GET | `/expence-management/category` | Get all categories |
| GET | `/expence-management/category/{id}` | Get category |
| PUT | `/expence-management/category/{id}` | Update category |
| DELETE | `/expence-management/category/{id}` | Delete category |

 Transaction

| Method | Endpoint | Description |
|---|---|---|
| POST | `/expence-management/transition` | Create transaction |
| GET | `/expence-management/transition` | Get user's transactions |
| GET | `/expence-management/transition/{id}` | Get transaction |
| PUT | `/expence-management/transition/{id}/amount` | Update amount |
| PUT | `/expence-management/transition/{id}/type` | Update type |
| PUT | `/expence-management/transition/{id}/description` | Update description |
| PUT | `/expence-management/transition/{id}/date` | Update date |
| PUT | `/expence-management/transition/{id}/category` | Update category |
| DELETE | `/expence-management/transition/{id}` | Delete transaction |

 Transaction Filtering
GET /expence-management/transition?type=Expense

GET /expence-management/transition?categoryId=1

GET /expence-management/transition?startDate=2026-09-01&endDate=2026-09-30

GET /expence-management/transition?type=Expense&categoryId=1&startDate=2026-09-01&endDate=2026-09-30


 Budget

| Method | Endpoint | Description |
|---|---|---|
| POST | `/expence-management/budget` | Create budget |
| GET | `/expence-management/budget` | Get user's budgets |
| GET | `/expence-management/budget/{id}` | Get budget |
| PUT | `/expence-management/budget/{id}/amount` | Update amount |
| PUT | `/expence-management/budget/{id}/month` | Update month |
| PUT | `/expence-management/budget/{id}/year` | Update year |
| DELETE | `/expence-management/budget/{id}` | Delete budget |

Summary

GET /expence-management/summary


Returns total income, total expenses, and balance.

 Budget Summary


GET /expence-management/budget-summary?month=September&year=2026


Returns the budget and actual expenses for the selected month.

 Authentication

The application uses JWT authentication.

Step 1 — Register
POST /expence-management/user

 Step 2 — Login
POST /auth/login


The server returns a JWT token.

 Step 3 — Use the Token

For protected endpoints, send:
Authorization: Bearer <JWT_TOKEN>


 Configuration

Create a MySQL database:
CREATE DATABASE expense_management;


Update your local `application.properties`:

properties
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/expense_management
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=YOUR_JWT_SECRET


 Never commit your real database password or JWT secret to GitHub.

Use `application-example.properties` as a template for other developers.

 How to Run

 1. Clone the repository
git clone YOUR_GITHUB_REPOSITORY_URL


 2. Open the project

Open the project in IntelliJ IDEA, Eclipse, or VS Code.

 3. Configure MySQL

Create the database and update your local configuration.

 4. Configure JWT Secret

Add your own JWT secret to `application.properties`.

 5. Run the application

Using Maven:
mvn spring-boot:run


Or run the main Spring Boot application class from your IDE.

 Testing

The REST APIs were tested using Postman.

Testing includes:
- User registration
- Login
- JWT authentication
- Category CRUD
- Transaction CRUD
- Transaction filtering
- Budget CRUD
- Expense summary
- Budget vs expense
- Validation
- User ownership/security

 Project Structure

src/
└── main/
    ├── java/
    │   └── com/
    │       └── expense/
    │           └── expence_management/
    │               ├── Entity/
    │               ├── Repo/
    │               ├── Services/
    │               ├── controllers/
    │               ├── JwtAuthenticationFilter.java
    │               └── SecurityConfig.java
    │
    └── resources/
        ├── application.properties
        └── application-example.properties


Future Improvements

Possible future improvements:
- Frontend dashboard
- Charts and graphs
- Monthly spending visualization
- Email notifications
- Recurring expenses
- Export transactions to CSV/PDF
- Cloud deployment
- More advanced reporting

Author

Y Molika

Java | Spring Boot | MySQL | REST API | Spring Security | JWT

 Project Highlights

This project demonstrates practical experience with:
- REST API development
- Spring Boot
- Spring Data JPA
- MySQL database design
- Authentication and authorization
- JWT
- Password encryption
- Entity relationships
- Validation
- Business logic
- Filtering
- Secure user-specific data access
