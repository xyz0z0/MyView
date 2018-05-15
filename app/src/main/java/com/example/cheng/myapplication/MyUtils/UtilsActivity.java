package com.example.cheng.myapplication.MyUtils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cheng.myapplication.R;

public class UtilsActivity extends AppCompatActivity {

    private Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnToast = findViewById(R.id.toast_button);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(UtilsActivity.this, "测试1");
            }
        });
    }
}
