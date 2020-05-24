package com.yyy.social_network.repository;

import com.yyy.social_network.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    User findUserByUsername(String username);
}
