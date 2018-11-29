package com.example.zdyview2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.zdyview2.R;

public class VolumneView extends View {
    private Paint mPaint;
    private int mCount;
    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private LinearGradient mLinearGradient;
    private double mRandom;
    private float mcurrentHeight;

    public static final int OFFSET = 5;


    public VolumneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
