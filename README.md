# 🚀 Spring Boot GraphQL API

A modern, scalable API project built with Spring Boot and GraphQL, designed to demonstrate best practices for secure, maintainable, and extensible backend development.

## ✨ Features

- ⚡ Quick and easy setup
- 🔗 GraphQL API support for flexible data queries
- 🔒 Secure authentication with JWT
- 🏗️ Layered architecture (Controller, Service, Repository)
- 🗂️ Multi-environment configuration (local, prod)
- 🛡️ Robust error handling and advanced logging

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
