package com.completableFuture.parser.account;

import com.completableFuture.parser.geo.GeoPoint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {
    private int timezone;
    private float longitude;
    private float latitude;
    private String dst;
    private String license;
    private String currency;

    // get name from license file
    private String name;
    // get city, state, zip from Geo files
    private String city;
    private String state;
    private String zip;
    private double exchangeRate;
    @JsonIgnore
    public GeoPoint getGeoPoint() {
        return new GeoPoint(latitude, longitude);
    }

}
