package it15225.launcher.android.androidlauncher.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import it15225.launcher.android.androidlauncher.Apps;
import it15225.launcher.android.androidlauncher.Extra;
import it15225.launcher.android.androidlauncher.Home;

public class HomeFragmentAdapter extends FragmentStatePagerAdapter {
  int mNumOfTabs;
    private static final String TAG = "HomeFragmentAdapter";
    Context mContext;

    public HomeFragmentAdapter(FragmentManager fm, int NumOfTabs, Context aContext) {
          super(fm);
        this.mNumOfTabs = NumOfTabs;
        mContext = aContext;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment Extra = new Extra();
                return Extra;
            case 1:
                Fragment Home = new Home();
                return Home;

            case 2:
                Fragment Apps = new Apps();
                return Apps;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}


