package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.model.address.NumberOfHouse;
import com.nastoiashcha.rest_api.repository.NumberOfHouseRepository;
import com.nastoiashcha.rest_api.service.NumberOfHouseService;
import org.springframework.stereotype.Service;

@Service
public class NumberOfHouseServiceImpl implements NumberOfHouseService {

    private final NumberOfHouseRepository numberOfHouseRepository;

    public NumberOfHouseServiceImpl(NumberOfHouseRepository numberOfHouseRepository) {
        this.numberOfHouseRepository = numberOfHouseRepository;
    }

    @Override
    public NumberOfHouse create(NumberOfHouse number) {
        return numberOfHouseRepository.save(number);
    }

    @Override
    public void delete(long id) {
        numberOfHouseRepository.deleteById(id);
    }
}
