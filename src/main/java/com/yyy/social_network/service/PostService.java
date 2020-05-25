package com.yyy.social_network.service;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;

import java.util.List;

public interface PostService {
    void create(Post post);
    void save(Post post);
    List<Post> findAll();
    Post findPostById(Long id);
    List<Post> findAllByUser(User user);
}
