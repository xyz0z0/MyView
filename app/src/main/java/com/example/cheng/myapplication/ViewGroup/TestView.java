package com.example.cheng.myapplication.ViewGroup;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {
  public TestView(Context context) {
    super(context);
  }


  public TestView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }


  public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }


  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
  }


  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(measureWidth(widthMeasureSpec), measureWidth(heightMeasureSpec));
  }


  private int measureWidth(int measureSpec) {
    int result;
    int specMode = MeasureSpec.getMode(measureSpec);
    int specSize = MeasureSpec.getSize(measureSpec);

    if (specMode == MeasureSpec.EXACTLY) {
      result = specSize;
    } else {
      result = 200;
      if (specMode == MeasureSpec.AT_MOST) {
        result = Math.min(result, specSize);
      }
    }
    return result;
  }

}
