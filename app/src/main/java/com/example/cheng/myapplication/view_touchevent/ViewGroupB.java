package com.example.cheng.myapplication.view_touchevent;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ViewGroupB extends LinearLayout {

    public ViewGroupB(Context context) {
        super(context);
    }

    public ViewGroupB(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupB(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("cxg", "ViewGroupB dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("cxg", "ViewGroupB onInterceptTouchEvent");
//        return super.onInterceptTouchEvent(ev);
        return true;
    }

    private int lastX;
    private int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("cxg", "ViewGroupB onTouchEvent");
//        return super.onTouchEvent(event);
//        return true;

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算移动的距离
                int offsetX = x -lastX;
                int offsetY = y - lastY;
                int l = getLeft()+offsetX;
                int b = getBottom()+offsetY;
                int r = getRight() + offsetX;
                int t = getTop()+offsetY;
                // 重新确认位置
                layout(l,t,r,b);
                break;
            case MotionEvent.ACTION_UP:
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
                params.setMargins(getLeft(),getTop(),0,0);
                break;
            default:
                break;
        }
        return true;
    }
}
