package com.example.cheng.myapplication.ThreadDemo;

import android.util.Log;

public class MyDemoThread extends Thread {

    private int num;

    public MyDemoThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        Log.d("cxg", "id " + Thread.currentThread().getId() + " num " + num);
    }
}
