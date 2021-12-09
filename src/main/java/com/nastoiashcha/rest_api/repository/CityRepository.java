package com.nastoiashcha.rest_api.repository;

import com.nastoiashcha.rest_api.model.address.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    boolean existsByName(String name);

    City findByName(String name);
}