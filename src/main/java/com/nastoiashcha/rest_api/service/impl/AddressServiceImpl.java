package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.model.address.Address;
import com.nastoiashcha.rest_api.repository.AddressRepository;
import com.nastoiashcha.rest_api.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(long id, Address address) {
        Address addressDb = addressRepository.getById(id);
        addressDb.setCity(address.getCity());
        addressDb.setStreet(address.getStreet());
        addressDb.setNumberOfHouse(address.getNumberOfHouse());
        return addressRepository.save(addressDb);
    }

    @Override
    public void delete(long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address findAddressById(long id) {
        return addressRepository.getById(id);
    }
}
