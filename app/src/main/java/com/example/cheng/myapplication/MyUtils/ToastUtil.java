package com.example.cheng.myapplication.MyUtils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

    private static Toast toast;

    public static void showToast(Context context, String desc) {
        if (toast == null) {
            toast = Toast.makeText(context, desc, Toast.LENGTH_SHORT);
        } else {
            toast.setText(desc);
        }
        toast.show();
    }


}
