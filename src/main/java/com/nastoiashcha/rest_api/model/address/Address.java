package com.nastoiashcha.rest_api.model.address;

import com.nastoiashcha.rest_api.model.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", nullable = false)
    private Street street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "houseNumber_id", nullable = false)
    private NumberOfHouse numberOfHouse;

    @OneToMany(mappedBy = "address")
    private List<User> users = new ArrayList<>();
}
