package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Like;
import com.yyy.social_network.repository.LikeRepository;
import com.yyy.social_network.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public void save(Like like) {
        likeRepository.save(like);
    }

}
