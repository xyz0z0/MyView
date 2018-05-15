package com.example.cheng.myapplication.viewpager_fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LazyLoadFragment extends Fragment {

    // 控件是否初始化完成
    private boolean isViewCreated;
    // 数据是否加载完毕
    private boolean isLoadDataCompleted;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        initViews(view);
        isViewCreated = true;
        return view;
    }

    public abstract int getLayout();
    public abstract void initViews(View view);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && isViewCreated && !isLoadDataCompleted){
            loadData();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint()){
            loadData();
        }
    }

    public void loadData() {
        isLoadDataCompleted = true;
    }
}
