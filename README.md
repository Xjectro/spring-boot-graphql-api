# 🚀 Spring Boot GraphQL API

Modern, scalable, and secure backend API template built with Spring Boot and GraphQL. This project demonstrates best practices for maintainable, extensible, and production-ready backend development.

---

## 📖 Overview

This repository provides a robust foundation for building GraphQL APIs using Spring Boot. It features JWT-based authentication, layered architecture, environment-specific configuration, and advanced error handling. Ideal for both learning and real-world applications.

---

## ✨ Features

- ⚡ **Quick Setup:** Minimal configuration, ready to use.
- 🔗 **GraphQL API:** Flexible data queries and mutations.
- 🔒 **JWT Authentication:** Secure endpoints with token-based auth.
- 🏗️ **Layered Architecture:** Controller, Service, Repository separation.
- 🗂️ **Multi-Environment Config:** Easily switch between local and production.
- 🛡️ **Robust Error Handling:** Centralized exception management.
- 📊 **Advanced Logging:** Configurable logging for debugging and monitoring.
- 🧪 **Comprehensive Testing:** Built-in test structure with Gradle.

---

## 🗂️ Project Structure

```
src/
  main/
    java/com/example/demo/
      config/         # GraphQL and security configs
      controller/     # REST/GraphQL controllers
      dto/            # Data Transfer Objects
      exception/      # Custom exceptions & handlers
      model/          # Entity models
      repository/     # Data access layer
      security/       # JWT & security logic
      service/        # Business logic
    resources/
      graphql/        # GraphQL schema
      application-*.properties # Env configs
      logback-spring.xml       # Logging config
  test/
    java/com/example/demo/     # Unit & integration tests
```

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- GraphQL Java
- JWT (JSON Web Token)
- Gradle
- Logback

---

## 🚦 Getting Started

### Prerequisites
- Java 17 or higher
- Gradle

### Installation

```bash
git clone https://github.com/Xjectro/spring-boot-graphql-api.git
cd spring-boot-graphql-api
./gradlew bootRun
```
> **For Windows users:**
> 
> ```powershell
> .\gradlew.bat bootRun
> ```

### Running Tests

```bash
./gradlew test
```

---

## ⚙️ Configuration

- All environment settings can be managed via `src/main/resources/application-*.properties` files.
- Default file: `application.properties`
- Example environment files: `application-local.properties`, `application-prod.properties`

---

## 🧩 GraphQL Usage

- **Endpoint:** `/graphql`
- **Schema:** `src/main/resources/graphql/schema.graphqls`

### Example Query

```graphql
query {
  users {
    id
    username
    email
  }
}
```

### Example Mutation

```graphql
mutation {
  createUser(input: {username: "test", password: "1234", email: "test@mail.com"}) {
    id
    username
  }
}
```

---

## 🧪 Testing & Logging

- All tests are located under `src/test/java/`.
- Logs are written by default to `logs/app.log`. Logging configuration is managed via `logback-spring.xml`.

---

## 🤝 Contributing

1. Fork this repo
2. Create your feature branch (`git checkout -b feature/awesome-feature`)
3. Commit your changes (`git commit -m 'Add awesome feature'`)
4. Push to the branch (`git push origin feature/awesome-feature`)
5. Open a Pull Request

> Please use clean code and descriptive commit messages when contributing.

---

## 📄 License

MIT

---

## 📬 Contact

For questions, suggestions, or support, please open an issue or contact [Xjectro](https://github.com/Xjectro).
