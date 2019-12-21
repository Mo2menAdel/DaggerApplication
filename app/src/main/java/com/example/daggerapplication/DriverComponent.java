package com.example.daggerapplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component
public interface DriverComponent {
//    Driver getDriver(String name);

    CarComponent
    .Factory// in case of petrolModule
    getActivityComponent(
            //DieselEngineModule dieselEngineModule // in case of using DieselModule
    );

    @Component.Factory
    interface Factory{
        DriverComponent create( @BindsInstance Driver dodo);
    }
}
