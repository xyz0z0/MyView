package com.example.cheng.myapplication.viewpager_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cheng.myapplication.R;

public class Main3Fragment extends LazyLoadFragment {

    private TextView textView1;

    @Override
    public int getLayout() {
        return R.layout.tab_main_fragment;
    }

    @Override
    public void initViews(View view) {
        textView1 = view.findViewById(R.id.fragment1_text);
    }

    @Override
    public void loadData() {
        super.loadData();
        textView1.setText("更改测试界面44444");
    }
}
