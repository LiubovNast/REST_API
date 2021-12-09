package com.nastoiashcha.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestException {

    private static final String NOT_FOUND = " not found";

    public RestException() {
    }

    public static ResponseStatusException invalidInput(String message) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }

    public static ResponseStatusException invalidName(String name) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name " + name + " consist indefinite symbols");
    }

    public static ResponseStatusException invalidNumber(String number) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Number " + number + " is invalid");
    }

    public static ResponseStatusException invalidDate(String message) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }

    public static ResponseStatusException userNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + NOT_FOUND);
    }

    public static ResponseStatusException addressNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with id " + id + NOT_FOUND);
    }

    public static ResponseStatusException cityNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "City with id " + id + NOT_FOUND);
    }

    public static ResponseStatusException streetNotFound(long id) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Street with id " + id + NOT_FOUND);
    }
}
