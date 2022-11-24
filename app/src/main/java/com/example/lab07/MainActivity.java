package com.example.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity implements FragmentOne.SendMessage1,FragmentTwo.SendMessage2{
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void sendData1(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo f = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }
    public void sendData2(String message) {
        String tag = "android:switcher:" + R.id.viewPager + ":" + 0;
        FragmentOne f = (FragmentOne) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }
}