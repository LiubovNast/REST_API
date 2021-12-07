package com.nastoiashcha.rest_api.service;

import com.nastoiashcha.rest_api.model.user.User;

public interface UserService {

    User create(User user);

    User update(long id, User user);

    void delete(long id);

    User findUserById(long id);
}
