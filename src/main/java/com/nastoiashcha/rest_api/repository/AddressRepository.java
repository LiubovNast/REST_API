package com.nastoiashcha.rest_api.repository;

import com.nastoiashcha.rest_api.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}