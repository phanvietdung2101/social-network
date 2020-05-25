package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Like;
import com.yyy.social_network.repository.LikeRepository;
import com.yyy.social_network.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public void save(Like like) {
        likeRepository.save(like);
    }

    @Override
    public List<Like> findAllByPostId(Long postId) {
        return likeRepository.findAllByPostId(postId);
    }


}
