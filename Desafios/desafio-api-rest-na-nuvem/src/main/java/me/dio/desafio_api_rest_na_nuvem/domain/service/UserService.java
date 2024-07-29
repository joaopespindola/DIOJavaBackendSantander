package me.dio.desafio_api_rest_na_nuvem.domain.service;

import me.dio.desafio_api_rest_na_nuvem.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}