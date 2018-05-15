package com.example.cheng.myapplication.password_input;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.cheng.myapplication.MainActivity;
import com.example.cheng.myapplication.R;

public class PasswordActivity extends AppCompatActivity {

    private SelfDialog selfDialog;
    private InputPasswordDialog passwordDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selfDialog = new SelfDialog(PasswordActivity.this);
                selfDialog.setTitle("提示1");
                selfDialog.setMessage("确定退出应用？");
                selfDialog.setYesOnclickListener("确定啊", new SelfDialog.onYesOnclickListener() {
                    @Override
                    public void onYesClick() {
                        Toast.makeText(PasswordActivity.this, "haha 1", Toast.LENGTH_SHORT).show();
                        selfDialog.dismiss();
                    }
                });
                selfDialog.setNoOnclickListerner("取消吧", new SelfDialog.onNoOnclickListerner() {
                    @Override
                    public void onNoClick() {
                        Toast.makeText(PasswordActivity.this, "取消了", Toast.LENGTH_SHORT).show();
                        selfDialog.dismiss();
                    }
                });
                selfDialog.show();
            }
        });

        findViewById(R.id.button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordDialog = new InputPasswordDialog(PasswordActivity.this);
                passwordDialog.setSubmitClickListener(new InputPasswordDialog.onSubmitClickListener() {
                    @Override
                    public void onSubmitClick(String passwordStr) {
                        Toast.makeText(PasswordActivity.this, passwordStr, Toast.LENGTH_SHORT).show();
                        passwordDialog.dismiss();
                    }
                });
                passwordDialog.show();
            }
        });
    }

}
