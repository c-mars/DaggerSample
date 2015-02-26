package c.mars.daggerr.sample;

import javax.inject.Singleton;

import c.mars.daggerr.MainActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 2/25/15.
 */
@Module (injects = { MainActivity.class }, library = true)
public class CarModule {
    public CarModule(String name) {
        this.name = name;
    }

    private String name;

    @Provides @Singleton Gas provideGas() { return new Gas(); }
    @Provides Car providesCar(Driver driver, Gas gas) { return new Car(driver, gas); }
    @Provides Driver providesDriver() { return new Driver(name); }

}

