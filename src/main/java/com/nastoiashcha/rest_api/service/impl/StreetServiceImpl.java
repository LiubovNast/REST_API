package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.model.address.Street;
import com.nastoiashcha.rest_api.repository.StreetRepository;
import com.nastoiashcha.rest_api.service.StreetService;
import org.springframework.stereotype.Service;

@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public Street create(String name) {
        return saveStreet(name);
    }

    private Street saveStreet(String name) {
        if (streetRepository.existsByName(name)) {
            return streetRepository.findByName(name);
        } else {
            var street = new Street();
            street.setName(name);
            streetRepository.save(street);
            return street;
        }
    }

    @Override
    public void delete(long id) {
        streetRepository.deleteById(id);
    }
}
