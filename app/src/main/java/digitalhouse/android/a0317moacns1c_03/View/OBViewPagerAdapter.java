package digitalhouse.android.a0317moacns1c_03.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import digitalhouse.android.a0317moacns1c_03.Fragment1OB;
import digitalhouse.android.a0317moacns1c_03.Fragment2OB;
import digitalhouse.android.a0317moacns1c_03.Fragment3OB;
import digitalhouse.android.a0317moacns1c_03.Fragment4OB;

/**
 * Created by dh3 on 15/07/17.
 */

public class OBViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;
    public OBViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1OB());
        fragmentList.add(new Fragment2OB());
        fragmentList.add(new Fragment3OB());
        fragmentList.add(new Fragment4OB());

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
