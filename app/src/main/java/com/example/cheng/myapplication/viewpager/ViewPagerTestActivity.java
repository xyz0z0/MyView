package com.example.cheng.myapplication.viewpager;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.cheng.myapplication.R;

import java.util.ArrayList;

public class ViewPagerTestActivity extends AppCompatActivity {

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);

        final ActionBar actionBar = getActionBar();
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());
//        mViewPager = findViewById(R.id.pager);
//        mViewPager.setAdapter(mDemoCollectionPagerAdapter);

//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//
//        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
//
//            @Override
//            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//            }
//
//            @Override
//            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
//
//            }
//        };
//
//        for (int i = 0;i<3;i++){
//            actionBar.addTab(
//                    actionBar.newTab()
//                    .setText("Tab "+(i+1))
//                    .setTabListener(tabListener));
//        }
    }
}
