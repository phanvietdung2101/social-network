package com.yyy.social_network.repository;

import com.yyy.social_network.model.Post;
import com.yyy.social_network.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findAllByUser(User user);
}
