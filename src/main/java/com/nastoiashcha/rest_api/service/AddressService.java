package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.Address;
import com.nastoiashcha.rest_api.model.user.UserSaveRequest;

public interface AddressService {

    Address create(UserSaveRequest address);

    Address update(long id, Address address);

    void delete(long id);

    Address findAddressById(long id);
}
