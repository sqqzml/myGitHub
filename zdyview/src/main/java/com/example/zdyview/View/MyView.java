package com.example.zdyview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    private Paint mPaint;
    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        mPaint = new Paint();
    }

    //测量宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(50);
       canvas.drawText("啦啦啦",0,50,mPaint);
       //画长方形
       canvas.drawRect(0,100,200,200,mPaint);
        //画线
        canvas.drawLine(0,100,100,100,mPaint);
    }
}
