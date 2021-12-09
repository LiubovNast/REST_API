package com.nastoiashcha.rest_api.repository;

import com.nastoiashcha.rest_api.model.address.NumberOfHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberOfHouseRepository extends JpaRepository<NumberOfHouse, Long> {

    boolean existsByNumber(String number);

    NumberOfHouse findByNumber(String number);
}