package com.yyy.social_network.repository;

import com.yyy.social_network.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
