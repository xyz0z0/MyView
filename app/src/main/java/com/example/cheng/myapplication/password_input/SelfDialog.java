package com.example.cheng.myapplication.password_input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cheng.myapplication.R;

public class SelfDialog extends Dialog {

    private Button yes;
    private Button no;
    private TextView titleTv;
    private TextView messageTv;
    private String titleStr;
    private String messageStr;
    private String yesStr, noStr;

    private onYesOnclickListener yesOnclickListener;
    private onNoOnclickListerner noOnclickListerner;

    public SelfDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
        if (str != null) {
            yesStr = str;
        }
        this.yesOnclickListener = onYesOnclickListener;
    }

    public void setNoOnclickListerner(String str, onNoOnclickListerner onNoOnclickListerner) {
        if (str != null) {
            noStr = str;
        }
        this.noOnclickListerner = onNoOnclickListerner;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_demo1);
        setCanceledOnTouchOutside(false);
        initView();
        initData();
        initEvent();
    }


    private void initView() {
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        titleTv = findViewById(R.id.title);
        messageTv = findViewById(R.id.message);
    }

    private void initData() {
        if (titleStr != null) {
            titleTv.setText(titleStr);
        }
        if (messageStr != null) {
            messageTv.setText(messageStr);
        }
        if (yesStr != null) {
            yes.setText(yesStr);
        }
        if (noStr != null) {
            no.setText(noStr);
        }
    }

    private void initEvent() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (yesOnclickListener != null) {
                    yesOnclickListener.onYesClick();
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noOnclickListerner != null) {
                    noOnclickListerner.onNoClick();
                }
            }
        });
    }

    public void setTitle(String title) {
        titleStr = title;
    }

    public void setMessage(String message) {
        messageStr = message;
    }

    public interface onYesOnclickListener {
        void onYesClick();
    }

    public interface onNoOnclickListerner {
        void onNoClick();
    }


}
