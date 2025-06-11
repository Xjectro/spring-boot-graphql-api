package com.example.demo.controller;

import com.example.demo.dto.CreateAdvertInput;
import com.example.demo.dto.DeleteAdvertInput;
import com.example.demo.model.Advert;
import com.example.demo.model.User;
import com.example.demo.repository.AdvertRepository;
import com.example.demo.service.AdvertService;

import graphql.GraphQLException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class AdvertController {
    private final AdvertRepository advertRepository;
    private final AdvertService advertService;

    public AdvertController(AdvertRepository advertRepository,AdvertService advertService) {
        this.advertRepository = advertRepository;
        this.advertService = advertService;
    }

    @QueryMapping
    public Advert[] adverts () {
        return advertRepository.findAll().toArray(Advert[]::new);
    }

    @QueryMapping
    public Advert advert(@Argument Long id ) {
        Advert advert = (Advert) advertRepository.findById(id).orElse(null);
        if(advert == null) {
            throw new GraphQLException("Advert not found");
        }

        return advert;
    }

    @MutationMapping
    public Advert createAdvert(@Argument CreateAdvertInput input, @ContextValue("request") HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        Advert advert = advertService.createAdvert(input.getTitle(),input.getDescription(),input.getPrice(),user);
        return advert;
    }

    @MutationMapping
    public boolean deleteAdvert(@Argument DeleteAdvertInput input, @ContextValue("request") HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        Advert advert = (Advert) advertRepository.findById(input.getId()).orElse(null);
        if (advert == null) {
            throw new GraphQLException("Advert not found!");
        }

        if (advert.getAuthor().getId() != user.getId()) {
            throw new GraphQLException("You can only delete your own adverts.");
        }

        boolean response = advertService.deleteAdvert(input.getId());

        return response;
    }
}
