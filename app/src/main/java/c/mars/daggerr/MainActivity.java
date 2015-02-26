package c.mars.daggerr;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import c.mars.daggerr.sample.Car;
import c.mars.daggerr.sample.CarApp;
import c.mars.daggerr.sample.Driver;
import c.mars.daggerr.sample.Gas;
import dagger.Lazy;
import dagger.ObjectGraph;


public class MainActivity extends ActionBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject Lazy<Car> car;
    @Inject Lazy<Driver> driver;
    @Inject Lazy<Gas> gas;

    @InjectView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        ObjectGraph objectGraph = ((CarApp) getApplication()).getObjectGraph();
        objectGraph.inject(this);

//        car is lazy inject - so it should be created here
        Log.d(TAG, "car model is " + car.get().getModel());

//        driver is lazy inject - it should me created here
        Log.d(TAG, "driver name is " + driver.get().getName());

//        this driver created without a car - so can't drive
        driver.get().drive();

//        this driver is created with car - so can drive
        car.get().getDriver().drive();

        textView.append("\n\ndriver name is "+car.get().getDriver().getName()+" and world's mark of gas is "+gas.get().getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
