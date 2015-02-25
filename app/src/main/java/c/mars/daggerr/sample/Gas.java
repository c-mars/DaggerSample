package c.mars.daggerr.sample;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Constantine Mars on 2/25/15.
 */
public class Gas {
    private static final String TAG = Gas.class.getSimpleName();

    public String getName() {
        return name;
    }

    private String name;

    @Inject
    public Gas() {
        this.name = "A-95";
        Log.d(TAG, Gas.class.getSimpleName() + " constructor");
    }
}
