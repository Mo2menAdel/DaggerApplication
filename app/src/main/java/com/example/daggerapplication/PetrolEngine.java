package com.example.daggerapplication;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

// impelemnt to Engine that defined to dagger 2
public class PetrolEngine implements Engine {
    private static final String TAG = "Car";

    private int horsePower;
    private int engineCapacity;

    @Inject
    public PetrolEngine(@Named("horse power") int horsePower,
                        @Named("engine capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        Log.d(TAG, "Petrol engine started. " +
                "\nHorsepower: " + horsePower +
                "\nEngine capacity: " + engineCapacity);
    }
}