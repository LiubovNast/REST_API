package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.RestException;
import com.nastoiashcha.rest_api.model.address.City;
import com.nastoiashcha.rest_api.repository.CityRepository;
import com.nastoiashcha.rest_api.service.CityService;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(String name) {
        return saveCity(name);
    }

    private City saveCity(String name) {
        if (cityRepository.existsByName(name)) {
            return cityRepository.findByName(name);
        } else {
            var city = new City();
            city.setName(name);
            cityRepository.save(city);
            return city;
        }
    }

    @Override
    public void delete(long id) {
        if (!cityRepository.existsById(id)) {
            throw RestException.cityNotFound(id);
        }
        cityRepository.deleteById(id);
    }
}
