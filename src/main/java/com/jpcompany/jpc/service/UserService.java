package com.jpcompany.jpc.service;

import com.jpcompany.jpc.model.User;
import com.jpcompany.jpc.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
