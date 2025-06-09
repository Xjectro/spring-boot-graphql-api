package com.example.demo.config;

import com.example.demo.security.RequiredIsLoggedInDirective;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {
    private final RequiredIsLoggedInDirective requiredIsLoggedInDirective;

    GraphQLConfig(RequiredIsLoggedInDirective requiredIsLoggedInDirective) {
        this.requiredIsLoggedInDirective = requiredIsLoggedInDirective;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .directive("requiredIsLoggedIn", requiredIsLoggedInDirective);
    }
}
