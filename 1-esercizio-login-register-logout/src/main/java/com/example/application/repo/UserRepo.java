package com.example.application.repo;

import com.example.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Questa classe è responsabili di comunicare col database
 * viene estesa da jpaRepo e abbiamo accesso a un set di metodi predefiniti*/

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();

}
