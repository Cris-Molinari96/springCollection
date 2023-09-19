package com.example.application.service.user;

import com.example.application.dto.UserDto;
import com.example.application.model.User;

public interface UserService {

    User findByUsername(String username);

    // per trasferire i dati utilizzeremo una classe DTO, perché secondo te non viene aggiunta all'interfaccia repo? (perché non comunica col db)
    User save(UserDto userDto);

}
