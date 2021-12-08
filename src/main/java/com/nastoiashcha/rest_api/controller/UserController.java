package com.nastoiashcha.rest_api.controller;

import com.nastoiashcha.rest_api.model.user.User;
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
    public User createUser(@RequestBody User request) {
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public User user(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable long id) {
        userService.delete(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable long id, @RequestBody User request) {
        return userService.update(id, request);
    }
}
