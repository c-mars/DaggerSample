package c.mars.daggerr.sample;

import android.app.Application;
import android.util.Log;

import dagger.ObjectGraph;

/**
 * Created by Constantine Mars on 2/25/15.
 */
public class CarApp extends Application {
    private static final String TAG = CarApp.class.getSimpleName();
    ObjectGraph objectGraph;

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new CarModule("Jack"));
    }
}
