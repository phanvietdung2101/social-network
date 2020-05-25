package com.yyy.social_network.service;

import com.yyy.social_network.model.Like;

import java.util.List;

public interface LikeService {
    void save(Like like);
    List<Like> findAllByPostId(Long postId);
}
