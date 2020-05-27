package com.yyy.social_network.repository;

import com.yyy.social_network.model.Like;
import com.yyy.social_network.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {
    Like findLikeByUser(User user);
    Like findLikeByUser_Username(String username);

}
