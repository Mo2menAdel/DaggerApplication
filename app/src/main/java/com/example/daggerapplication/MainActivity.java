package com.example.daggerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.daggerapplication.Car;
import com.example.daggerapplication.CarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
//    way 1
//    private Car car;

    @Inject
    Car car1,car2; //Field Injection(way 2 )
    // $ this way would create a non null car object automatically
    // $ you could inject any time of car objects you want and only call one inject method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CarComponent component = DaggerCarComponent.create() ; // normall call

//        Run time var method one
//        ------------------------
//        CarComponent component = DaggerCarComponent.builder()
//                .dieselEngineModule(new DieselEngineModule(100))
//                .build(); // call with run time integer that the dagger don't know where to get

//        Run time var method two
//        ------------------------

//        CarComponent component = DaggerCarComponent.builder()
//                .horsePower(150)
//                .engineCapacity(1400)
//                .build();

//        component to Same Driver and Same car:
//        --------------------------------------
//        CarComponent component = DaggerCarComponent.builder()
//                .horsePower(150)
//                .engineCapacity(1400)
//                .getDriverComponent(((ExampleApp)getApplication()).getAppComponent())
//                .build();


////        component to Same Driver and Same car with sub-component:
////        ----------------------------------------------------------
//        CarComponent component = ((ExampleApp) getApplication()).getAppComponent()
//                .getActivityComponent()
//                .horsePower(120)
//                .engineCapacity(150)
//                .build();

//        component to Same Driver and Same car with sub-component (factory based):
//        ----------------------------------------------------------
        CarComponent component = ((ExampleApp) getApplication()).getAppComponent()
                .getActivityComponent().create(150,200)
                ;


        component.inject(this); // the second way(Field injection)
        // any car object in the main could use the same object
        // car = component.getCar(); //// way 1
        car1.drive();
        car2.drive();
    }
}
