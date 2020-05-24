package com.yyy.social_network.repository;

import com.yyy.social_network.model.Role;
import com.yyy.social_network.model.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
