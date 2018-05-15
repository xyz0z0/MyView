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

public class MainFragment extends LazyLoadFragment {


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Log.d("cxg","MainFragment onCreateView");
//        return inflater.inflate(R.layout.tab_main_fragment,container,false);
//    }

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
        textView1.setText("更改测试界面");
    }
}
