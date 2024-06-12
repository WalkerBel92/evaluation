# User Registration API

This is a demo application for user management using Spring Boot. The application includes validations for the email and password fields during user registration.

## Requirements

- Java 17 or higher
- Maven 3.6.3 or higher

## Installation

### Using Maven

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/repository-name.git
    ```
2. Navigate to the project directory:

    ```bash
    cd repository-name
    ```
3. Compile and package the application using Maven:

    ```bash
    ./mvnw clean package
    ```
4. Run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

## Swagger
Once the application is running, you can check the documentation by visiting the [Swagger](http://localhost:8080/swagger-ui/index.html)

## Endpoints

### Create User

- **URL:** `/users/`
- **Method:** `POST`
- **Description:** Creates a new user with the provided data.

- **Request Body:**

    ```json
    {
      "name": "User Name",
      "email": "user@domain.com",
      "password": "Password1!",
      "phones": [
        {
          "number": "123456789",
          "cityCode": "1",
          "countryCode": "57"
        }
      ]
    }
    ```

- **Response:**

    ```json
    {
      "id": "UUID",
      "created": "2024-05-24T10:00:00Z",
      "modified": "2024-05-24T10:00:00Z",
      "lastLogin": "2024-05-24T10:00:00Z",
      "isActive": true
    }
    ```

## Error Handling

Validation errors return an HTTP status code 400 and a response body describing the errors.

### Example Error Response

```json
{
  "name": "Name is required",
  "email": "Invalid email format",
  "password": "Password must be at least 8 characters long, including an uppercase letter, a lowercase letter, a number, and a special character"
}
````

