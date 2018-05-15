package com.example.cheng.myapplication.password_input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cheng.myapplication.R;

public class InputPasswordDialog extends Dialog {

    private TextView tvTip;
    private EditText etPassword;
    private Button btnSubmit;

    private onSubmitClickListener submitClickListener;

    public InputPasswordDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    public void setSubmitClickListener(onSubmitClickListener onSubmitClickListener) {
        this.submitClickListener = onSubmitClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_password);
        setCanceledOnTouchOutside(false);
        initView();
        initEvent();
    }


    private void initView() {
        tvTip = findViewById(R.id.tip_text);
        etPassword = findViewById(R.id.password_edittext);
        btnSubmit = findViewById(R.id.submit_button);
    }

    private void initEvent() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (submitClickListener != null) {
                    submitClickListener.onSubmitClick(etPassword.getText().toString());
                }
            }
        });
    }

    public interface onSubmitClickListener {
        void onSubmitClick(String passwordStr);
    }
}
