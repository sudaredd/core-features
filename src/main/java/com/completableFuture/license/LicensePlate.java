package com.completableFuture.license;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class LicensePlate {
    private String license;
    private String state;
    private String name;
}
