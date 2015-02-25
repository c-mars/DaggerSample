package c.mars.daggerr.sample;

import android.util.Log;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by Constantine Mars on 2/25/15.
 */
public class Car {
    private static final String TAG = Car.class.getSimpleName();

    public Lazy<Gas> getGas() {
        return gas;
    }

    @Inject
    Lazy<Gas> gas;

    private String model;

    @Inject
    public Car() {
        this.model = "Ford";
        Log.d(TAG, Car.class.getSimpleName()+" constructor");
    }

    public String getModel() {
        return model;
    }

    public void go() {
        Log.d(TAG, model+" goes on gas \""+gas.get().getName()+"\"");
    }
}
