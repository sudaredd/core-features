package com.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableMultiTasks {

    public static void main(String[] args) {
        List<String> nams = Arrays.asList("darsan,reddy,sudar,bhavya,divya".split(","));
        AtomicInteger atomicInteger = new AtomicInteger();


       for(String name: nams) {
           upperAndInt(atomicInteger, name)
                   .thenAccept(s-> System.out.println(s))
           .join();

         String append =   upperAndInt(atomicInteger, name)
                   .join();
           System.out.println("append:"+append);
       }

    }

    private static CompletableFuture<String> upperAndInt(AtomicInteger atomicInteger, String name) {
        return CompletableFuture.supplyAsync(()->name.toUpperCase())
        .thenApplyAsync(m->m + atomicInteger.getAndIncrement());
    }
}
