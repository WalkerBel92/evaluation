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

### List users

- **URL:** `/users/`
- **Method:** `GET`
- **Description:** Retrieves a list of all users.

- **Response:**

    ```json
    [
      {
          "id": "73a6edfa-fb17-49b2-b666-22656e99b569",
          "name": "Brian",
          "email": "bbeltran.1803@gmail.com",
          "password": "Beltran92.",
          "created": "2024-08-19T15:06:14.645+00:00",
          "modified": "2024-08-19T15:06:14.645+00:00",
          "lastLogin": "2024-08-19T15:06:14.645+00:00",
          "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYmVsdHJhbi4xODAzQGdtYWlsLmNvbSIsImlhdCI6MTcyNDA3OTk3NCwiZXhwIjoxNzI0MTY2Mzc0fQ.SzfHY6OEXwFj33y80bBOMryXp6r0d4xXWvbvYOgeZPSjOEy42DHPyAUh1s-P532p9BrM6dwAd7xIDXI3VbHU6A",
          "phones": [
              {
                  "id": "4bf70e9f-17c9-41f9-91fe-2351dbd0926e",
                  "number": "984633384",
                  "cityCode": "1",
                  "countryCode": "2"
              }
          ],
          "active": true
      },
      {
          "id": "87a6edfa-fb17-49b2-b666-22656e99b582",
          "name": "Alexis",
          "email": "alexis.9292@gmail.com",
          "password": "Loloy729.",
          "created": "2024-08-19T15:06:14.645+00:00",
          "modified": "2024-08-19T15:06:14.645+00:00",
          "lastLogin": "2024-08-19T15:06:14.645+00:00",
          "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYmVsdHJhbi4xODAzQGdtYWlsLmNvbSIsImlhdCI6MTcyNDA3OTk3NCwiZXhwIjoxNzI0MTY2Mzc0fQ.SzfHY6OEXwFj33y80bBOMryXp6r0d4xXWvbvYOgeZPSjOEy42DHPyAUh1s-P532p9BrM6dwAd7xIDXI3VbHU6A",
          "phones": [
              {
                  "id": "4bf70e9f-17c9-41f9-91fe-2351dbd0926e",
                  "number": "984632284",
                  "cityCode": "1",
                  "countryCode": "2"
              }
          ],
          "active": true
      }
    ]
    ```

### Get User by UUID

- **URL:** `/users/{id}`
- **Method:** `GET`
- **Description:** Retrieves a user by their unique identifier (UUID).

- **Response:**

    ```json
    
  {
      "id": "73a6edfa-fb17-49b2-b666-22656e99b569",
      "name": "Brian",
      "email": "bbeltran.1803@gmail.com",
      "password": "Beltran92.",
      "created": "2024-08-19T15:06:14.645+00:00",
      "modified": "2024-08-19T15:06:14.645+00:00",
      "lastLogin": "2024-08-19T15:06:14.645+00:00",
      "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYmVsdHJhbi4xODAzQGdtYWlsLmNvbSIsImlhdCI6MTcyNDA3OTk3NCwiZXhwIjoxNzI0MTY2Mzc0fQ.SzfHY6OEXwFj33y80bBOMryXp6r0d4xXWvbvYOgeZPSjOEy42DHPyAUh1s-P532p9BrM6dwAd7xIDXI3VbHU6A",
      "phones": [
          {
              "id": "4bf70e9f-17c9-41f9-91fe-2351dbd0926e",
              "number": "984633384",
              "cityCode": "1",
              "countryCode": "2"
          }
      ],
      "active": true
  }
    
    ```

### Delete User by UUID

- **URL:** `/users/{id}`
- **Method:** `DELETE`
- **Description:** Delete a user by their unique identifier (UUID).

- **Response:** No content

### Update User by UUID

- **URL:** `/users/{id}`
- **Method:** `PATCH`
- **Description:** Partially update a user by their unique identifier (UUID).

- **Request Body:**

    ```json
    {
      "name": "User Name",
      "email": "user@domain.com"
    }
    ```

- **Response:**

    ```json
    
  {
      "id": "73a6edfa-fb17-49b2-b666-22656e99b569",
      "name": "User Name",
      "email": "user@domain.com",
      "password": "Beltran92.",
      "created": "2024-08-19T15:06:14.645+00:00",
      "modified": "2024-08-19T15:06:14.645+00:00",
      "lastLogin": "2024-08-19T15:06:14.645+00:00",
      "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYmVsdHJhbi4xODAzQGdtYWlsLmNvbSIsImlhdCI6MTcyNDA3OTk3NCwiZXhwIjoxNzI0MTY2Mzc0fQ.SzfHY6OEXwFj33y80bBOMryXp6r0d4xXWvbvYOgeZPSjOEy42DHPyAUh1s-P532p9BrM6dwAd7xIDXI3VbHU6A",
      "phones": [
          {
              "id": "4bf70e9f-17c9-41f9-91fe-2351dbd0926e",
              "number": "984633384",
              "cityCode": "1",
              "countryCode": "2"
          }
      ],
      "active": true
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

