package com.example.cheng.myapplication.ViewGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class MyTextView extends AppCompatEditText {

  private Paint mPaint1;
  private Paint mPaint2;


  public MyTextView(Context context) {
    super(context);

  }


  public MyTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    initPaint();
  }


  public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }


  private void initPaint() {
    mPaint1 = new Paint();
    mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
    mPaint1.setStyle(Paint.Style.FILL);
    mPaint2 = new Paint();
    mPaint2.setColor(Color.YELLOW);
    mPaint2.setStyle(Paint.Style.FILL);
  }


  @Override protected void onDraw(Canvas canvas) {
    canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
    canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
    canvas.save();
    canvas.translate(10, 0);
    super.onDraw(canvas);
    canvas.restore();
  }
}
