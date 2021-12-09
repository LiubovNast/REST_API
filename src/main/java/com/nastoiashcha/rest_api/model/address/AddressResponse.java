package com.nastoiashcha.rest_api.model.address;

public record AddressResponse(String city,
                              String street,
                              String number) {

    public static AddressResponse getFromAddress(Address address){
        return new AddressResponse(address.getCity().getName(),
                address.getStreet().getName(),
                address.getNumberOfHouse().getNumber());
    }
}
