package digitalhouse.android.a0317moacns1c_03.View;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rd.PageIndicatorView;

import digitalhouse.android.a0317moacns1c_03.R;

public class OnBoardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        ViewPager viewPager = (ViewPager) findViewById(R.id.onBoardingViewpager);
        OBViewPagerAdapter obViewPagerAdapter = new OBViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(obViewPagerAdapter);

        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(viewPager);
    }
}
