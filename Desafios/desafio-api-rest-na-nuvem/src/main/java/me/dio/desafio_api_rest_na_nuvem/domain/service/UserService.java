package me.dio.desafio_api_rest_na_nuvem.domain.service;

import me.dio.desafio_api_rest_na_nuvem.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    User create(User userToCreate);
}