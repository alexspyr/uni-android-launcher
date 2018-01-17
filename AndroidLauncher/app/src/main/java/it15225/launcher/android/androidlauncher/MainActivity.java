package it15225.launcher.android.androidlauncher;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import it15225.launcher.android.androidlauncher.Adapters.HomeFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivity";
    private TabLayout tabLayout;
    private static ViewPager viewPager;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#000000")));
        tabLayout.addTab(tabLayout.newTab().setText("Extras"));
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Apps"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final HomeFragmentAdapter adapter = new HomeFragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), mContext);

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.setCurrentItem(1);
    }

}
