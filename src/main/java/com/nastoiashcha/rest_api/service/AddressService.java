package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.address.Address;

public interface AddressService {

    Address create(Address address);

    Address update(long id, Address address);

    void delete(long id);

    Address findAddressById(long id);
}
