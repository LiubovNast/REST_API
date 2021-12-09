package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.Street;

public interface StreetService {

    Street create(String name);

    void delete(long id);
}
