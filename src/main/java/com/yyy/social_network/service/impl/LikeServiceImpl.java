package com.yyy.social_network.service.impl;

import com.yyy.social_network.model.Like;
import com.yyy.social_network.model.User;
import com.yyy.social_network.repository.LikeRepository;
import com.yyy.social_network.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Override
    public void save(Like like) {
        likeRepository.save(like);
    }

    @Override
    public Like findLikeByUser(User user) {
        return likeRepository.findLikeByUser(user);
    }


    @Override
    public void delete(Like like) {
        likeRepository.delete(like);
    }

    @Override
    public Like findLikeByUser_Username(String username) {
        return likeRepository.findLikeByUser_Username(username);
    }


}
