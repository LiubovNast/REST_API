package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.RestException;
import com.nastoiashcha.rest_api.model.address.Address;
import com.nastoiashcha.rest_api.model.user.UserSaveRequest;
import com.nastoiashcha.rest_api.repository.AddressRepository;
import com.nastoiashcha.rest_api.service.AddressService;
import com.nastoiashcha.rest_api.service.CityService;
import com.nastoiashcha.rest_api.service.NumberOfHouseService;
import com.nastoiashcha.rest_api.service.StreetService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CityService cityService;
    private final StreetService streetService;
    private final NumberOfHouseService numberOfHouseService;

    public AddressServiceImpl(AddressRepository addressRepository,
                              CityService cityService,
                              StreetService streetService,
                              NumberOfHouseService numberOfHouseService) {
        this.addressRepository = addressRepository;
        this.cityService = cityService;
        this.streetService = streetService;
        this.numberOfHouseService = numberOfHouseService;
    }

    @Override
    public Address create(UserSaveRequest request) {
        return createAddress(request);
    }

    private Address createAddress(UserSaveRequest request) {
        Address address = new Address();
        address.setCity(cityService.create(request.city()));
        address.setStreet(streetService.create(request.street()));
        address.setNumberOfHouse(numberOfHouseService.create(request.number()));
        addressRepository.save(address);
        return address;
    }

    @Override
    public Address update(long id, Address address) {
        if (!addressRepository.existsById(id)) {
            throw RestException.addressNotFound(id);
        }
        Address addressDb = addressRepository.getById(id);
        addressDb.setCity(address.getCity());
        addressDb.setStreet(address.getStreet());
        addressDb.setNumberOfHouse(address.getNumberOfHouse());
        return addressRepository.save(addressDb);
    }

    @Override
    public void delete(long id) {
        if (!addressRepository.existsById(id)) {
            throw RestException.addressNotFound(id);
        }
        addressRepository.deleteById(id);
    }

    @Override
    public Address findAddressById(long id) {
        if (!addressRepository.existsById(id)) {
            throw RestException.addressNotFound(id);
        }
        return addressRepository.getById(id);
    }
}
