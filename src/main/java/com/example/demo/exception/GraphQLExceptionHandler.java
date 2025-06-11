package com.example.demo.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {
    private static final Logger logger = LoggerFactory.getLogger(GraphQLExceptionHandler.class);

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, graphql.schema.DataFetchingEnvironment env) {
        System.out.println(ex instanceof GraphQLException);
        if (ex instanceof GraphQLException) {
            logger.warn("GraphQLException: {}", ex.getMessage());
            return GraphqlErrorBuilder.newError(env)
                    .message(ex.getMessage())
                    .errorType(ErrorType.BAD_REQUEST)
                    .build();
        } else {
            logger.error("Internal server error", ex);
            return GraphqlErrorBuilder.newError(env)
                    .message("Internal server error")
                    .errorType(ErrorType.INTERNAL_ERROR)
                    .build();
        }
    }
}
