package com.example.fintech_zerobase.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String country;
    private String streetAddress;

}
