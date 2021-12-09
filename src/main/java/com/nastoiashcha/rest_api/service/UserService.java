package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.user.User;
import com.nastoiashcha.rest_api.model.user.UserResponse;
import com.nastoiashcha.rest_api.model.user.UserSaveRequest;

public interface UserService {

    UserResponse create(UserSaveRequest user);

    UserResponse update(long id, String name);

    void delete(long id);

    UserResponse findUserById(long id);
}
