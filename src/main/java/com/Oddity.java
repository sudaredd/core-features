package com;

import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;


public class Oddity {
    private static int[] o =
        ThreadLocalRandom.current().ints()
//            .limit(1000000)
            .limit(2)
            .parallel()
            .filter(i -> (i & 1) == 1).toArray();


    private static int[] o1 = new SplittableRandom().ints()
        .limit(1000000)
//        .parallel()
        .filter(i -> (i & 1) == 1). toArray();

    public static void main(String[] args) {
//        System.out.println(o.length);
        System.out.println(o1.length);
    }
}
