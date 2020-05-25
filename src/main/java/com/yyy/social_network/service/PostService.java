package com.yyy.social_network.service;

import com.yyy.social_network.model.Post;

import java.util.List;

public interface PostService {
    void create(Post post);
    void save(Post post);
    List<Post> findAll();
    Post findPostById(Long id);
}
