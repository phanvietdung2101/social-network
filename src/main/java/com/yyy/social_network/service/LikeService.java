package com.yyy.social_network.service;

import com.yyy.social_network.model.Like;
import com.yyy.social_network.model.User;

import java.util.List;

public interface LikeService {
    void save(Like like);
    Like findLikeByUser(User user);
    void delete(Like like);
    Like findLikeByUser_Username(String username);
}
