package com.yyy.social_network.service;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface PostService {
    void create(Post post);
    void save(Post post);
    List<Post> findAll();
    Post findPostById(Long id);
    List<Post> findAllByUser(User user);
    Page<Post> find5TrendingPost();
}
