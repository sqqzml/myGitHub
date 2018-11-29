package com.example.zdyview2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.zdyview2.R;


/**
 * 自己在value文件夹下新建attrs文件 就可以在它里面定义自己想要的属性了
 * 咱们自定义View初始化的东西要放到构造函数之后执行
 * 因为我们自己写的View执行顺序
 * 1：构造方法
 * 2：测量
 *
 *
 */
public class MyView extends View {

    private String text;
    private int circleColor;
    private int arcColor;
    private int textColor;
    private float textSize;
    private int startAngle;
    private int sweepAngle;
    private int mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private RectF mRectF;
    private Paint mArcPaint;
    private Paint mTextPaint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //得到我们自己定义的属性集合
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        if (ta != null) {
            //两个参数  参数1：R.styleable.MyView_circleColor 代表的咱们自己定义属性集合
            //参数2：如果你在布局文件里面没有添加定义的属性 就给一个默认值
            circleColor = ta.getColor(R.styleable.MyView_circleColor, 0);
            arcColor = ta.getColor(R.styleable.MyView_arcColor, 0);
            textColor = ta.getColor(R.styleable.MyView_textColor, 0);
            textSize = ta.getDimension(R.styleable.MyView_textSize, 50);
            text = ta.getString(R.styleable.MyView_text);
            startAngle = ta.getInt(R.styleable.MyView_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.MyView_sweepAngle, 90);
            ta.recycle();
            Log.e("text", text);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }

    private void drawSth(Canvas canvas) {
        init();
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
        canvas.drawText(text, 0, text.length(), mCircleXY, mCircleXY + textSize
                / 4, mTextPaint);
    }

    private void init() {
        //getWidth() 得到当前这个空间宽和高
        int length = Math.min(getWidth(), getHeight());
        Log.e("看看宽和高", "宽度：" + getWidth() + "高度：" + getHeight());
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(circleColor);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(arcColor);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((getWidth() * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(textColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("onMeasure", "onMeasure");
    }
}
