package com.nastoiashcha.rest_api.model.address;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "numbers_of_houses")
public class NumberOfHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String number;

    @OneToMany(mappedBy = "numberOfHouse")
    private List<Address> addresses = new ArrayList<>();
}
