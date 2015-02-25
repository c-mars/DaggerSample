package c.mars.daggerr.sample;

import android.util.Log;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by Constantine Mars on 2/25/15.
 */
public class Driver {
    private static final String TAG = Driver.class.getSimpleName();
    private static final String[] NAMES = {"Jack", "Bob", "Milla"};
    public String getName() {
        return name;
    }

    private String name;
    private Car car;

    @Inject
    public Driver() {
        this.name = NAMES[new Random().nextInt(3)];
        Log.d(TAG, Driver.class.getSimpleName()+" "+this.name+" constructor");
    }

    public void chooseCar(Car car) {
        this.car = car;
    }

    public void drive() {
        if (car == null) {
            Log.d(TAG, "no car, can't drive!");
            return;
        }
        Log.d(TAG, name+" is driving "+car.getModel());
        car.go();
    }
}
