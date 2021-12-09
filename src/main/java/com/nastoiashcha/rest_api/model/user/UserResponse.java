package com.nastoiashcha.rest_api.model.user;

import com.nastoiashcha.rest_api.model.address.AddressResponse;

import java.util.Date;

public record UserResponse(long id,
                           String name,
                           int age,
                           Date dateOfBirth,
                           AddressResponse address) {

    public static UserResponse getFromUser(User user){
        return new UserResponse(user.getId(),
                user.getName(),
                user.getAge(),
                user.getDateOfBirth(),
                AddressResponse.getFromAddress(user.getAddress()));
    }
}
