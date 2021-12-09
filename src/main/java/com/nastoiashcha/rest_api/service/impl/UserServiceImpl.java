package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.RestException;
import com.nastoiashcha.rest_api.model.user.User;
import com.nastoiashcha.rest_api.model.user.UserResponse;
import com.nastoiashcha.rest_api.model.user.UserSaveRequest;
import com.nastoiashcha.rest_api.repository.UserRepository;
import com.nastoiashcha.rest_api.service.AddressService;
import com.nastoiashcha.rest_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    private static final long MS_IN_YEAR = 1000L * 60 * 60 * 24 * 365;

    public UserServiceImpl(UserRepository userRepository,
                           AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Override
    public UserResponse create(UserSaveRequest request) {
        checkInput(request);
        return UserResponse.getFromUser(saveUser(request));
    }

    private void checkInput(UserSaveRequest request) {
        checkName(request.name());
        checkName(request.city());
        checkName(request.street());
        checkDate(request.dateOfBirth());
        checkNumber(request.number());
    }

    private void checkNumber(String number) {
        if (number.isBlank() || number.isEmpty()) {
            throw RestException.invalidInput("Number can't be empty!!");
        } else if (number.startsWith("0")) {
            throw RestException.invalidInput("Number can't start with 0");
        } else if (!number.matches("\\d{1,4}\\s?\\-?[A-Za-z]?")) {
            throw RestException.invalidNumber(number);
        }
    }

    private void checkDate(Date dateOfBirth) {
        if (dateOfBirth == null) {
            throw RestException.invalidInput("Date can't be null");
        } else if (dateOfBirth.after(new Date())) {
            throw RestException.invalidDate("You input wrong date");
        }
    }

    private void checkName(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw RestException.invalidInput("Name can't be empty!!");
        } else if (!name.matches("[A-Za-z]+")) {
            throw RestException.invalidName(name);
        }
    }

    private User saveUser(UserSaveRequest request) {
        var user = new User();
        user.setDateOfBirth(request.dateOfBirth());
        user.setName(request.name());
        int age = getAge(request.dateOfBirth());
        user.setAge(age);
        var address = addressService.create(request);
        user.setAddress(address);
        userRepository.save(user);
        return user;
    }

    private int getAge(Date dateOfBirth) {
        return (int) ((new Date().getTime() - dateOfBirth.getTime()) / MS_IN_YEAR);
    }

    @Override
    public UserResponse update(long id, String name) {
        if (!userRepository.existsById(id)) {
            throw RestException.userNotFound(id);
        }
        checkName(name);
        User userDb = userRepository.getById(id);
        userDb.setName(name);
        return UserResponse.getFromUser(userRepository.save(userDb));
    }

    @Override
    public void delete(long id) {
        if (!userRepository.existsById(id)) {
            throw RestException.userNotFound(id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse findUserById(long id) {
        if (!userRepository.existsById(id)) {
            throw RestException.userNotFound(id);
        }
        return UserResponse.getFromUser(userRepository.getById(id));
    }
}
