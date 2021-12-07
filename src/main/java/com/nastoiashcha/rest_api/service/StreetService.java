package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.Street;

public interface StreetService {

    Street create(Street street);

    void delete(long id);
}
