package com.yyy.social_network.service;

import com.yyy.social_network.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(User user);
    User findUserByUsername(String username);
    Page<User> find5LatestUser(Pageable pageable);
    User findUserByUserId(Long id);
}
