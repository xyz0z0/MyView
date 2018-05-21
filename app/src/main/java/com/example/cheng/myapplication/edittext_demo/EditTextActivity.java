package com.example.cheng.myapplication.edittext_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cheng.myapplication.R;

public class EditTextActivity extends AppCompatActivity {

    private AppCompatEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        editText = findViewById(R.id.demo1_edittext);
//        editText.setSelection(2,3);
        editText.selectAll();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("cxg","beforeTextChanged "+s);
                Log.d("cxg"," "+start+" "+count+" "+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("cxg","onTextChanged "+s);
                Log.d("cxg"," "+start+" "+before+" "+count);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("cxg","afterTextChanged "+s);
                Toast.makeText(EditTextActivity.this, s, Toast.LENGTH_SHORT).show();
            }

        });
    }
}
