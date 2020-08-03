package com.completableFuture.parser.geo;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class GeoPoint {
    private final float latitude;
    private final float longitude;
}
