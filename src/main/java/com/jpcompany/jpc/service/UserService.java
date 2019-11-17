package com.jpcompany.jpc.service;

import com.jpcompany.jpc.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}
