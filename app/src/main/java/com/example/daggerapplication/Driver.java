package com.example.daggerapplication;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Driver {

    String name;
    @Inject
    public Driver(String name) {
        this.name = name;
    }
}
