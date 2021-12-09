package com.nastoiashcha.rest_api.model.user;

import java.util.Date;

public record UserSaveRequest(String name,
                              Date dateOfBirth,
                              String city,
                              String street,
                              String number) {
}
