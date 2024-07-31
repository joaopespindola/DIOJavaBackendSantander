package me.dio.desafio_api_rest_na_nuvem.domain.service.implementation;

import me.dio.desafio_api_rest_na_nuvem.domain.model.User;
import me.dio.desafio_api_rest_na_nuvem.domain.repository.UserRepository;
import me.dio.desafio_api_rest_na_nuvem.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}