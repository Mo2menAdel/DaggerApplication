package com.example.daggerapplication;

import android.app.Application;

public class ExampleApp extends Application {

    private DriverComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerDriverComponent.factory().create(new Driver("Bol-bol"));
    }

    public DriverComponent getAppComponent() {
        return component;
    }
}
