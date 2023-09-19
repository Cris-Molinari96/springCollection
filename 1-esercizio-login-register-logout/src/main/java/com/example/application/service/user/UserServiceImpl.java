package com.example.application.service.user;

import com.example.application.dto.UserDto;
import com.example.application.model.User;
import com.example.application.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder; // questo oggetto in particolare il metodo encode() sarà utilizzato quando verrà registrato un nuovo utente. la password ovviamente sarà inserita in formato crypto
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()), userDto.getFullname());
        return userRepo.save(user);
    }
}
