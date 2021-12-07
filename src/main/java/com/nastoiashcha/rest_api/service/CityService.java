package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.City;

public interface CityService {

    City create(City city);

    void delete(long id);
}
