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

import java.util.Random;

public class ZPView2 extends View implements View.OnClickListener {
    //文字内容
    private String[] contents=new String[]{"美 食", "购 物", "商 场", "丰 满", "性 感", "知 性"};
 //转盘颜色
    private int[] colors=new int[]{Color.parseColor("#8EE5EE"), Color.parseColor("#FFD700"), Color.parseColor("#FFD39B"), Color.parseColor("#FF8247"), Color.parseColor("#FF34B3")};
  //宽高
    private int mWidth;
    private Context Mcontext;
    //初始字体
    private String mStr="开始";
    //初始化画笔
    private Paint mPaint;
    public ZPView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        Mcontext=context;
        mPaint=new Paint();
        //添加点击事件
        setOnClickListener(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(800,800);
        //得到测量后的宽和高
        mWidth=getMeasuredWidth();

    }

    //开始绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //因为要画扇形 里面有个RectF
        //因为那个园其实是占全屏的，所以我这个RectF的空间也是全屏
        RectF rectF = new RectF(0, 0, mWidth, mWidth);
        mPaint.setStyle(Paint.Style.FILL);
        for (int i=0;i<colors.length;i++){
            mPaint.setColor(colors[i]);
            int startjd=i*60;
            canvas.drawArc(rectF,startjd,60,true,mPaint);
        }
//设置画笔颜色
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(40);
        for (int i=0;i<contents.length;i++){
            int startJd=i*60;
            Path path = new Path();
            path.addArc(rectF,startJd,60);
            canvas.drawTextOnPath(contents[i],path,150,150,mPaint);
        }
        //里面绘制的小圆
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
        canvas.drawCircle(mWidth/2,mWidth/2,80,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        Rect rect = new Rect();
        mPaint.getTextBounds(mStr, 0, mStr.length(), rect);
        int width = rect.width();
        int height = rect.height();
        canvas.drawText(mStr, mWidth / 2 - width / 2, mWidth / 2 + height / 2, mPaint);

       // canvas.drawLine(0,0,mWidth/2 ,mWidth/2 ,mPaint);
    }

    @Override
    public void onClick(View v) {
        Random random = new Random();
        int jd = random.nextInt(1000);
        int du = jd % 360 + 1000;
        RotateAnimation rotateAnimation = new RotateAnimation(du, jd, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatMode(0);
        rotateAnimation.setInterpolator(new LinearInterpolator());

       // startAnimation(rotateAnimation);
        startAnimation(rotateAnimation);
    }
}
