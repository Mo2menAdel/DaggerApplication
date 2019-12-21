package com.example.daggerapplication;

import com.example.daggerapplication.Rims;
import com.example.daggerapplication.Tires;
import com.example.daggerapplication.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    @Provides
    static // java 7war
    Rims // the daggerinteerested in the call object not in the method name
    provideRims() {
        return new Rims();
    }

    @Provides
    static Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
