package digitalhouse.android.a0317moacns1c_03.View;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rd.PageIndicatorView;

import digitalhouse.android.a0317moacns1c_03.R;
import digitalhouse.android.a0317moacns1c_03.utils.ShakeDetector;

public class OnBoardingActivity extends AppCompatActivity {
    private ShakeDetector mShakeDetector;
    private Sensor mAccelerometer;
    private SensorManager mSensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.onBoardingViewpager);
        OBViewPagerAdapter obViewPagerAdapter = new OBViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(obViewPagerAdapter);

        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(viewPager);
        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
                /*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
             //   Toast.makeText(OnBoardingActivity.this, "SE SHEIKEO" + count, Toast.LENGTH_SHORT).show();
               // handleShakeEvent(count);
                if (viewPager.getCurrentItem()== 3){
                    finish();
                }

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    private void handleShakeEvent(int count) {
        Toast.makeText(this, "SE SHEIKEO" + count, Toast.LENGTH_SHORT).show();

    }
}
