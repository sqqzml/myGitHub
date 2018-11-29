package com.example.zdyview2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class ZPView extends View implements View.OnClickListener {
    private Paint mPaint;
    private Paint strPaint;
    private int mWidth;
    private int mPadding;
    private RectF mRectF;
    private String mStr = "开始";
    private String[] contents = new String[]{"美 女", "女 神", "热 舞", "丰 满", "性 感", "知 性"};

    public ZPView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        setOnClickListener(this);
    }


    private void initPaint() {
        strPaint = new Paint();
        strPaint.setStyle(Paint.Style.STROKE);
        strPaint.setAntiAlias(true);
        strPaint.setColor(Color.WHITE);
        strPaint.setStrokeWidth(5);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2 - mPadding, mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        //绘制 6个椭圆
        initArc(canvas);
        //绘制里面的小圆
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mWidth / 2, mWidth / 2, 50, mPaint);


        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(24);
        Rect rect = new Rect();
        mPaint.getTextBounds(mStr, 0, mStr.length(), rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText(mStr, mWidth / 2 - width / 2, mWidth / 2 + height / 2, mPaint);

    }

    public int[] colors = new int[]{Color.parseColor("#8EE5EE"), Color.parseColor("#FFD700"), Color.parseColor("#FFD39B"), Color.parseColor("#FF8247"), Color.parseColor("#FF34B3"), Color.parseColor("#F0E68C")};

    private void initArc(Canvas canvas) {

        for (int i = 0; i < 6; i++) {
            mPaint.setColor(colors[i]);
            //绘制圆弧，含圆心
            canvas.drawArc(mRectF, (0 - i) * 60 + 60, 60, true, mPaint);
        }
        for (int i = 0; i < 6; i++) {
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(24);
            Path path = new Path();
            path.addArc(mRectF, (0 - i) * 60 + 60, 60);
            canvas.drawTextOnPath(contents[i], path, 60, 60, mPaint);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(300, 300);
        mWidth = getWidth();
        mPadding = 5;
        initRectf();
    }

    private void initRectf() {
        mRectF = new RectF(0, 0, mWidth, mWidth);
    }

    @Override
    public void onClick(View v) {
        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatMode(0);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        startAnimation(rotateAnimation);
    }
}
