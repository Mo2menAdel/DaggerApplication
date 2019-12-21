package com.example.daggerapplication;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

//    Normal case
// --------------
//    @Binds // instead of Provides use Binds to save code and run time.
//    abstract // to save but remember to make the class abstract too
//    Engine // return type
//    bindEngine(DieselEngine engine // passed impliment to the return interface that defined to dagger2
//    );

// with run time variable:
// -----------------------
    private int horsePower;

////    you could pass it with constructor
    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }
    @Provides
    Engine provideEngine() {
        return new DieselEngine(horsePower);
    }
    // you could pass it with function to make it easier BUT inject the constructor
//    @Provides
//    int provideHorsePower() {
//        return horsePower;
//    }
//
//    @Provides
//    Engine provideEngine(DieselEngine engine) {
//        return engine;
//    }
}