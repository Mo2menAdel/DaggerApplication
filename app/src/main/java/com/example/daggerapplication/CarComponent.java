package com.example.daggerapplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@SameCar
@Subcomponent // dagger annotation that wil construct the methods in the interface automatically
        (      // dependencies = DriverComponent.class, // to connect with the other component
                modules = {WheelsModule.class,
                PetrolEngineModule.class // only one of the interface modules is passed to here
        }) // this part you should add when using modules
public interface CarComponent {

    Car getCar(); // To return the car automatically the dagger needs  to know where to start,so we
    // annotate the constructor (the start to build the object value) with inject

    void inject(MainActivity mainActivity); // adding value to the objects car

//    @Component.Builder
    /*@Subcomponent.Builder
    interface Builder {

        @BindsInstance // annotation to return run time builder
        Builder horsePower(@Named("horse power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engine capacity") int engineCapacity);

//      NO NEED IN SUBCOMPONENT
//        Builder getDriverComponent(DriverComponent driver);

        CarComponent build();
    }*/
    @Subcomponent.Factory
    interface Factory{
        CarComponent create(@BindsInstance @Named("horse power") int horsePower,
                           @BindsInstance @Named("engine capacity") int engineCapacity);
    }
}
