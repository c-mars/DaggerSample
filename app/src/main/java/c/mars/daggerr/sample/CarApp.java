package c.mars.daggerr.sample;

import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.ObjectGraph;

/**
 * Created by Constantine Mars on 2/25/15.
 */
public class CarApp extends Application {
    private static final String TAG = CarApp.class.getSimpleName();
    @Inject Lazy<Car> car;
    @Inject Lazy<Driver> driver;

    @Override
    public void onCreate() {
        super.onCreate();

//        create and inject graph right here
        ObjectGraph objectGraph = ObjectGraph.create(new CarModule());
        objectGraph.inject(this); // can be also made in CarModule by annotation args injects = ...

//        car is lazy inject - so it should be created here
        Log.d(TAG, "car model is "+car.get().getModel());

//        driver is lazy inject - it should me created here
        Log.d(TAG, "driver name is "+driver.get().getName());

//        no car - can't drive!
        driver.get().drive();

//      enable driving by getting car
        driver.get().chooseCar(car.get());

//        gas is lazy - it should be created here, before driving
        driver.get().drive();
    }
}
