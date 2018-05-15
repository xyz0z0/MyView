package com.example.cheng.myapplication.viewpager_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.cheng.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainViewPagerActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout mTabMain;
    private LinearLayout mTabCommunity;
    private LinearLayout mTabShopping;
    private LinearLayout mTabMe;
    private ImageButton mImageTabMain;
    private ImageButton mImageTabCommunity;
    private ImageButton mImageTabShopping;
    private ImageButton mImageTabMe;

    private ViewPager mViewPager;
    private TabFragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_view_pager);
        initView();
        initClickListener();
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.tab_main_viewpager);
        mTabMain = (LinearLayout) findViewById(R.id.id_tab_main);
        mTabCommunity = (LinearLayout) findViewById(R.id.id_tab_community);
        mTabShopping = (LinearLayout) findViewById(R.id.id_tab_shopping);
        mTabMe = (LinearLayout) findViewById(R.id.id_tab_me);
        mImageTabMain = (ImageButton) findViewById(R.id.tab_main_icon_grey);
        mImageTabCommunity = (ImageButton) findViewById(R.id.tab_community_icon_grey);
        mImageTabShopping = (ImageButton) findViewById(R.id.tab_shopping_cart_icon_grey);
        mImageTabMe = (ImageButton) findViewById(R.id.tab_me_icon_grey);

        mFragments = new ArrayList<Fragment>();
        Fragment mTab_01 = new MainFragment();
        Fragment mTab_02 = new Main1Fragment();
        Fragment mTab_03 = new Main2Fragment();
        Fragment mTab_04 = new Main3Fragment();
        mFragments.add(mTab_01);
        mFragments.add(mTab_02);
        mFragments.add(mTab_03);
        mFragments.add(mTab_04);

        mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                initTabImage();
                switch (currentItem) {
                    case 0:
                        mImageTabMain.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 1:
                        mImageTabCommunity.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 2:
                        mImageTabShopping.setImageResource(R.mipmap.ic_launcher_round);
                        break;
                    case 3:
                        mImageTabMe.setImageResource(R.mipmap.ic_launcher_round);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

    private void initTabImage(){
        mImageTabMain.setImageResource(R.mipmap.ic_launcher_round);
        mImageTabCommunity.setImageResource(R.mipmap.ic_launcher_round);
        mImageTabShopping.setImageResource(R.mipmap.ic_launcher_round);
        mImageTabMe.setImageResource(R.mipmap.ic_launcher_round);
    }

    private void initClickListener() {
        mTabMain.setOnClickListener(this);
        mTabCommunity.setOnClickListener(this);
        mTabShopping.setOnClickListener(this);
        mTabMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_main:
                // initTabImage();
                //mImageTabMain.setImageResource(R.drawable.tab_main_icon_green);
                //注意上面修改的只是图标的状态,还要修改相对应的fragment;
                setSelect(0);
                break;
            case R.id.id_tab_community:
                setSelect(1);
                break;
            case R.id.id_tab_shopping:
                setSelect(2);
                break;
            case R.id.id_tab_me:
                setSelect(3);
                break;
        }

    }

    //设置将点击的那个图标为亮色,切换内容区域
    private void setSelect(int i) {

        initTabImage();
        switch (i) {
            case 0:
                mImageTabMain.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case 1:
                mImageTabCommunity.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case 2:
                mImageTabShopping.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case 3:
                mImageTabMe.setImageResource(R.mipmap.ic_launcher_round);
                break;
            default:
                break;
        }
        mViewPager.setCurrentItem(i,false);
    }
}
