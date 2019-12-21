package com.example.daggerapplication;

public class Wheels {

//      FIRST CASE

//    @Inject
//    public Wheels() {
//
//    }

    // SECOND CASE
    // we don't own this class so we can't annotate it with @Inject

    private Rims rims;
    private Tires tires;

    public Wheels(Rims rims, Tires tires) {
        this.rims = rims;
        this.tires = tires;
    }
}
