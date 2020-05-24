package com.yyy.social_network.service;

import com.yyy.social_network.model.User;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(User user);
    User findUserByUsername(String username);
}
