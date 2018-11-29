package com.example.zdyview2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class CounterView extends View implements View.OnClickListener{
    //定义画笔
    private Paint mPaint;
    //用于获取文字的宽高
    private Rect mBounds;
    //计算值，每点击一次本控件，其值增加
    private int mCount;
    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔、Rect
      mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        //点击事件
        setOnClickListener(this);

    }

    protected void onDraw(Canvas canvas) {
               super.onDraw(canvas);

                mPaint.setColor(Color.BLUE);
                // 绘制一个填充色为蓝色的矩形
                 canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

                 mPaint.setColor(Color.YELLOW);
                mPaint.setTextSize(50);
                 String text = String.valueOf(mCount);
                 // 获取文字的宽和高
                 mPaint.getTextBounds(text, 0, text.length(), mBounds);
                float textWidth = mBounds.width();
                 float textHeight = mBounds.height();

                 // 绘制字符串
                canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                                 + textHeight / 2, mPaint);
            }
    @Override
    public void onClick(View v) {
  mCount++;
  //重绘
        invalidate();
    }
}