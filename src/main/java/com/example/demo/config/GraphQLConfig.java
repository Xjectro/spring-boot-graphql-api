package com.example.demo.config;

import com.example.demo.security.RequiredIsLoggedInDirective;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.graphql.server.WebGraphQlInterceptor;

@Configuration
public class GraphQLConfig {
    private final RequiredIsLoggedInDirective requiredIsLoggedInDirective;
    private final GraphQLRequestInterceptor graphQLRequestInterceptor;

    GraphQLConfig(RequiredIsLoggedInDirective requiredIsLoggedInDirective, GraphQLRequestInterceptor graphQLRequestInterceptor) {
        this.requiredIsLoggedInDirective = requiredIsLoggedInDirective;
        this.graphQLRequestInterceptor = graphQLRequestInterceptor;
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .directive("requiredIsLoggedIn", requiredIsLoggedInDirective);
    }

    @Bean
    public WebGraphQlInterceptor webGraphQlInterceptor() {
        return graphQLRequestInterceptor;
    }
}
