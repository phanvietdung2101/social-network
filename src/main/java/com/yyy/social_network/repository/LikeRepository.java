package com.yyy.social_network.repository;

import com.yyy.social_network.model.Like;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {
    List<Like> findAllByPostId(Long postId);
}
