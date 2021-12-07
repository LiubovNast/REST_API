package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.NumberOfHouse;

public interface NumberOfHouseService {

    NumberOfHouse create(NumberOfHouse number);

    void delete(long id);
}
