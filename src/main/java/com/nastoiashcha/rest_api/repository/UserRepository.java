package com.nastoiashcha.rest_api.repository;

import com.nastoiashcha.rest_api.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}