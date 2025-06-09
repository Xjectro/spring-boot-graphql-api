package com.example.demo.security;

import com.example.demo.exception.GraphQLException;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class RequiredIsLoggedInDirective implements SchemaDirectiveWiring {

    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
        DataFetcher<?> originalFetcher = env.getFieldDataFetcher();

        env.setFieldDataFetcher((DataFetchingEnvironment dataEnv) -> {
            HttpServletRequest request = (HttpServletRequest) dataEnv.getGraphQlContext().get("request");
            Boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
            if (isLoggedIn == null || !isLoggedIn) {
                throw new GraphQLException("Unauthorized: You must be logged in");
            }
            return originalFetcher.get(dataEnv);
        });

        return env.getElement();
    }
}
