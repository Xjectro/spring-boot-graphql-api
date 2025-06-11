package com.example.demo.service;

import com.example.demo.model.Advert;
import com.example.demo.model.User;
import com.example.demo.repository.AdvertRepository;
import com.example.demo.exception.GraphQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
    this.advertRepository = advertRepository;
    }

    @Transactional
    public Advert createAdvert(String title, String description, Double price, User author) {
        Advert advert = new Advert(title, description, price, author);
        return advertRepository.save(advert);
    }

    @Transactional
    public boolean deleteAdvert(Long id) {
        if (advertRepository.existsById(id)) {
            advertRepository.deleteById(id);
            return true;
        } else {
            throw new GraphQLException("Advert not found!");
        }
    }
}
