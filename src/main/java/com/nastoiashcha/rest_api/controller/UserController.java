package com.nastoiashcha.rest_api.controller;

import com.nastoiashcha.rest_api.model.user.User;
import com.nastoiashcha.rest_api.model.user.UserResponse;
import com.nastoiashcha.rest_api.model.user.UserSaveRequest;
import com.nastoiashcha.rest_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserSaveRequest request) {
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public UserResponse user(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUserName(@PathVariable long id, @RequestBody String name) {
        return userService.update(id, name);
    }
}
