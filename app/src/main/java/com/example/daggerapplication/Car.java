package com.example.daggerapplication;

import android.util.Log;

import com.example.daggerapplication.Engine;
import com.example.daggerapplication.Remote;
import com.example.daggerapplication.Wheels;

import javax.inject.Inject;

@SameCar
public class Car {
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;
    private Driver driver;

    @Inject // $ the constructor will be initiated with dagger
    // $ but you should annotate Engine and wheels classes to initiate them as well.
    // $ if one of them is gahez library and you can't change in it you could initiate module class
    // that inject them to make dagger know how to buils them (tires and rims example)
    // $ As you have injection annotation in the constructor, the other injected method will
    // compiled automatically.
    // $ if it wasn't injected you would do that in the main by injection method.
    public Car( Driver driver, Engine engine, Wheels wheels) {
        this.driver = driver;
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject // injected method
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        Log.d(TAG, driver + " drives " + this);
    }
}
