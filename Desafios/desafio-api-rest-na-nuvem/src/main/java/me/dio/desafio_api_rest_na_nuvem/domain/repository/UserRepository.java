package me.dio.desafio_api_rest_na_nuvem.domain.repository;

import me.dio.desafio_api_rest_na_nuvem.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
