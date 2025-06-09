# 🚀 Spring Boot GraphQL API

A modern, scalable API project built with Spring Boot and GraphQL, designed to demonstrate best practices for secure, maintainable, and extensible backend development.

## ✨ Features
- ⚡ Quick and easy setup
- 🔗 GraphQL API support for flexible data queries
- 🔒 Secure authentication with JWT
- 🏗️ Layered architecture (Controller, Service, Repository)
- 🗂️ Multi-environment configuration (local, prod)
- 🛡️ Robust error handling and advanced logging

## 📖 About This Project
This repository provides a production-ready template for building GraphQL APIs using Spring Boot. It is structured to help developers quickly bootstrap new projects with a strong foundation for security, scalability, and maintainability. The project includes JWT-based authentication, a clear separation of concerns via layered architecture, and environment-specific configuration files. It is ideal for both learning and real-world applications.

## 📦 Getting Started

### Prerequisites
- Java 17 or higher
- Gradle

### Installation

```bash
git clone https://github.com/Xjectro/spring-boot-graphql-api.git
cd spring-boot-graphql-api
./gradlew bootRun
```

### Running Tests

```bash
./gradlew test
```

## ⚙️ Configuration
You can customize environment-specific settings by editing the `application-*.properties` files under `src/main/resources/`.

## 🧩 GraphQL Usage
- Endpoint: `/graphql`
- Schema: `src/main/resources/graphql/schema.graphqls`

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repository and submit pull requests. You can also open issues for bug reports, feature requests, or questions. Please follow best practices and provide clear commit messages.

## 📄 License
MIT

---

> **Note:** This repository is open to the community. If you find it useful, please consider starring the project! ⭐
