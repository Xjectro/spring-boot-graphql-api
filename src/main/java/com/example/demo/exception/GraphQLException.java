package com.example.demo.exception;

public class GraphQLException extends RuntimeException {
    public GraphQLException(String message) {
        super(message);
    }
}
