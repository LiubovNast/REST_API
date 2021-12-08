package com.nastoiashcha.rest_api.service.impl;

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
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(long id) {
        cityRepository.deleteById(id);
    }
}
