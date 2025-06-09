package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class AuthFilter extends HttpFilter {
    private final TokenManager tokenManager;
    private final UserRepository userRepository;

    AuthFilter(TokenManager tokenManager, UserRepository userRepository) {
        this.tokenManager = tokenManager;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            try {
                Long userId = tokenManager.verifyToken(token);
                User user = userRepository.findById(userId).orElse(null);
                if (user != null) {
                    request.setAttribute("user", user);
                    request.setAttribute("isLoggedIn", true);
                } else {
                    request.setAttribute("isLoggedIn", false);
                }
            } catch (Exception e) {
                request.setAttribute("isLoggedIn", false);
            }
        } else {
            request.setAttribute("isLoggedIn", false);
        }

        chain.doFilter(request, response);
    }
}