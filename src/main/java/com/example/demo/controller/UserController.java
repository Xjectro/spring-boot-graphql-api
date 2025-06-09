package com.example.demo.controller;

import com.example.demo.dto.AuthenticationUserInput;
import com.example.demo.dto.CreateUserInput;
import com.example.demo.dto.DeleteUserInput;
import com.example.demo.dto.UpdateUserInput;
import com.example.demo.exception.GraphQLException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private final UserRepository repository;
    private final UserService userService;

    public UserController(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    // Of course, in a real project this won't be like this.
    @QueryMapping
    public List<User> users() {
        return repository.findAll();
    }

    @MutationMapping
    public User createUser(@Argument CreateUserInput input) {
        User user = userService.createUser(input.getUsername(), input.getEmail(), input.getPassword());
        return user;
    }

    @MutationMapping
    public User updateUser(@Argument UpdateUserInput input, @ContextValue("request") HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        User updatedUser = userService.updateUser(user, input.getUsername());
        return updatedUser;
    }

    @MutationMapping
    public boolean deleteUser(@Argument DeleteUserInput input, @ContextValue("request") HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        if (user.getId() != input.getId()) {
            throw new GraphQLException("You can only delete your own account.");
        }
        Boolean response = userService.deleteUser(input.getId());
        return response;
    }

    @MutationMapping
    public String authentication(@Argument AuthenticationUserInput input) {
        String token = userService.authentication(input.getEmail(), input.getPassword());
        return token;
    }

    @QueryMapping
    public User currentUser(@ContextValue("request") HttpServletRequest request) {
        Boolean isLoggedIn = (Boolean) request.getAttribute("isLoggedIn");
        if (isLoggedIn != null && isLoggedIn) {
            User user = (User) request.getAttribute("user");
            return user;
        }
        return null;
    }
}
