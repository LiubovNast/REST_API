package com.nastoiashcha.rest_api.service.impl;

import com.nastoiashcha.rest_api.model.user.User;
import com.nastoiashcha.rest_api.repository.UserRepository;
import com.nastoiashcha.rest_api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(long id, User user) {
        User userDb = userRepository.getById(id);
        userDb.setName(user.getName());
        userDb.setAddress(user.getAddress());
        userDb.setAge(user.getAge());
        userDb.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(userDb);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(long id) {
        return userRepository.getById(id);
    }
}
