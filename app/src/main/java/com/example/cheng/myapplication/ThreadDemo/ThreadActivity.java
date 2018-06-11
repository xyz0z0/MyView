package com.example.cheng.myapplication.ThreadDemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.cheng.myapplication.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        int num = 233;
        Log.d("cxg", "id " + Thread.currentThread().getId() + " num " + num);
        new MyDemoThread(1).start();
        new MyDemoThread(2).start();
        new MyDemoThread(3).start();
    }

    public class MyThread extends Thread{

    }
}
