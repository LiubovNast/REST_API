package com.nastoiashcha.rest_api.repository;

import com.nastoiashcha.rest_api.model.address.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {

    boolean existsByName(String name);

    Street findByName(String name);
}