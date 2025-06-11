# Spring Boot GraphQL Advertisement Platform

This project is a web platform where users can create and manage advertisements. The backend is built with Spring Boot, provides a GraphQL API, and uses JWT-based authentication for security. Users can register, log in, and manage their ads.

## Features
- User registration and login (JWT authentication)
- Add, delete, update, and list advertisements
- Flexible data querying with GraphQL API
- Simple web interface (HTML + JS) for ad creation and user actions
- Layered architecture (Controller, Service, Repository)
- Error handling and customizable exception messages

## Technologies Used
- Java 17+
- Spring Boot
- Spring Security (JWT)
- GraphQL (Spring for GraphQL)
- H2/other database support
- Basic frontend with HTML/JS

## Setup
1. Clone the repository:
   ```bash
   git clone <your-repo-link>
   cd spring-boot-graphql-api
   ```
2. Install dependencies and build the project:
   ```bash
   ./gradlew build
   ```
3. Start the application:
   ```bash
   ./gradlew bootRun
   ```

## Usage
- The app runs at `http://localhost:8080` by default.
- GraphQL endpoint: `http://localhost:8080/graphql`
- Web interfaces:
  - Register: `/register`
  - Login: `/login`
  - Create advert: `/create`
- After login, your JWT token is stored in localStorage and used automatically for ad operations.

## GraphQL API
### Main Types
- **User**: id, username, email, roles
- **Advert**: id, title, description, price, author

### Queries
```graphql
query {
  adverts {
    id
    title
    description
    price
    author { username }
  }
}
```

### Mutations
Create user:
```graphql
mutation {
  createUser(input: {username: "ali", email: "ali@mail.com", password: "1234"})
}
```
Login (returns token):
```graphql
mutation {
  authentication(input: {email: "ali@mail.com", password: "1234"})
}
```
Create advert:
```graphql
mutation {
  createAdvert(input: {title: "Bicycle for Sale", description: "Clean, barely used.", price: 1500}) {
    id
    title
  }
}
```

## Authentication
- Registration and login are handled via GraphQL mutations.
- After login, the returned JWT token should be sent in the Authorization header.
- Some actions (add/delete advert) require authentication.

## Contributing
Contributions are welcome! Please open an issue before submitting a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Template Used: https://github.com/Xjectro/spring-boot-graphql-api
