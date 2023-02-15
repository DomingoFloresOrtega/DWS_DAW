package org.iesvdm.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "person_addresses", joinColumns = @JoinColumn(name = "person_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "house_number")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "city", column = @Column(name = "city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code")),
    })
    private Set<Address> addresses = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "person_phone_numbers", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "phone_number")
    private Set<String> phoneNumbers;
}
