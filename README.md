
Here’s the updated `README.md` to reflect the use of **MongoDB Atlas** as your database:

---

# Role-Based Access Control (RBAC) with JWT Authentication and Authorization

## Overview

This project demonstrates a **Role-Based Access Control (RBAC)** system implemented using **Spring Boot** and **JWT (JSON Web Tokens)** for secure authentication and authorization. The system supports two roles:

1. **Admin**:
   - Can view all clients.
   - Can add new clients.
   - Can remove existing clients.

2. **User**:
   - Can only view clients.

The application uses **MongoDB Atlas** for storing user credentials and client data.

---

## Features

- **JWT Authentication**:
  - Users authenticate with their credentials to receive a JWT token.
  - Tokens are used to validate requests and assign roles.

- **Role-Based Authorization**:
  - Access to endpoints is controlled based on roles (`ADMIN` or `USER`).

- **Endpoints**:
  - `/auth/login` - Authenticate and obtain a JWT.
  - `/clients` - View client data (accessible to both `ADMIN` and `USER`).
  - `/clients/add` - Add a client (accessible only to `ADMIN`).
  - `/clients/remove/{id}` - Remove a client (accessible only to `ADMIN`).

- **Database Integration**:
  - **MongoDB Atlas** is used for persistent storage of users and clients.

---

## Technologies Used

- **Spring Boot**: Backend framework.
- **JWT**: For secure stateless authentication.
- **Spring Security**: For authentication and authorization.
- **MongoDB Atlas**: Cloud-based NoSQL database.
- **Maven**: Build automation.

---

## Prerequisites

1. **MongoDB Atlas Account**: Set up a cluster in MongoDB Atlas and obtain the connection string.
2. **Java Development Kit (JDK)**: Ensure JDK 17 or higher is installed.
3. **Maven**: Ensure Maven is installed.

---

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/rbac-jwt.git
   cd rbac-jwt
   ```

2. **Set Up MongoDB Atlas Connection**:
   - Update the `application.properties` file with your MongoDB Atlas connection string:
     ```properties
     spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<database>?retryWrites=true&w=majority
     ```

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - Swagger UI (if enabled): [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   - Default server port: `8080`

---

## API Endpoints

### Authentication
- **POST** `/auth/login`  
  Authenticate and receive a JWT token.  
  **Request Body**:
  ```json
  {
    "username": "admin",
    "password": "admin123"
  }
  ```

  **Response**:
  ```json
  {
    "token": "your-jwt-token"
  }
  ```

---

### Client Management
#### View Clients
- **GET** `/clients`  
  Accessible to both `USER` and `ADMIN`.

#### Add Client
- **POST** `/clients/add`  
  Accessible only to `ADMIN`.  
  **Request Body**:
  ```json
  {
    "name": "Client Name",
    "email": "client@example.com"
  }
  ```

#### Remove Client
- **DELETE** `/clients/remove/{id}`  
  Accessible only to `ADMIN`.

---

## Role Details

1. **Admin**:
   - Can access all endpoints, including `/clients/add` and `/clients/remove/{id}`.
2. **User**:
   - Restricted to viewing clients via `/clients`.

---

## Database Details

### MongoDB Atlas

- **Database**: MongoDB Atlas
- **Collections**:
  1. `users`: Stores user credentials and roles.
  2. `clients`: Stores client information.
  
- Sample `users` document:
  ```json
  {
    "_id": "64d0cabc1234567890",
    "username": "admin",
    "password": "hashed_password",
    "roles": ["ADMIN"]
  }
  ```

- Sample `clients` document:
  ```json
  {
    "_id": "64d0cabc0987654321",
    "name": "Client Name",
    "email": "client@example.com"
  }
  ```

---

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

--- 

Let me know if you'd like to make further adjustments!
