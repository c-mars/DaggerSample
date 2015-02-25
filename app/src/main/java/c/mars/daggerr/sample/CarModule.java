package c.mars.daggerr.sample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Constantine Mars on 2/25/15.
 */
@Module (injects = {CarApp.class, Gas.class}, library = true)
public class CarModule {
    @Provides @Singleton Gas provideGas() {
        return new Gas();
    }
}

