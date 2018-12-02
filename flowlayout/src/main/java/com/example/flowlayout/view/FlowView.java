package com.example.flowlayout.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flowlayout.R;

public class FlowView extends LinearLayout {
    Context context;
    private int widthPixels;
    private FlowView flowView;
    private String datum;

    public FlowView(Context context,AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        //得到系统屏幕的宽高
        widthPixels = metrics.widthPixels;
        //设置这个布局垂直显示
        setOrientation(VERTICAL);

    }
    //初始化数据
    public void setData(String[] data){
        LinearLayout linearLayout = getLin();
        for (int i = 0; i <data.length ; i++) {
            datum = data[i];
            int numLength=0;
            //要得到有多少个子控件
            int childCount = linearLayout.getChildCount();
            //这个for循环只是计算一行控件的宽和高
            for (int j = 0; j <childCount ; j++) {
                TextView tv = (TextView) linearLayout.getChildAt(j);
                LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
               //测量Textview的宽和高
                int leftMargin = layoutParams.leftMargin;
                tv.measure(getMeasuredWidth(),getMeasuredHeight());
                numLength+=tv.getMeasuredWidth()+leftMargin;
            }

            final TextView text = getText();
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            params.leftMargin=10;
            params.topMargin=2;
            text.setLayoutParams(params);
            text.setText(datum);
            text.measure(getMeasuredWidth(),getMeasuredHeight());
            int measuredWidth = text.getMeasuredWidth()+text.getPaddingLeft()+text.getPaddingRight();
             if (measuredWidth>=widthPixels){
                 String s = datum.substring(0, 4);
                 text.setText(s);
                 text.measure(getMeasuredWidth(),getMeasuredHeight());
                 measuredWidth=text.getMeasuredWidth();
             }

            if (widthPixels>=numLength+measuredWidth){
                linearLayout.addView(text);
            }else{
                linearLayout= getLin();
               linearLayout.addView(text);

            }
            //点击进行吐司
            text.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,text.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    //初始化子布局
    private LinearLayout getLin(){
        LinearLayout linearLayout = new LinearLayout(getContext());
        //控件组件大小的工具类
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        //this本类对象
        this.addView(linearLayout);
        return linearLayout;

    }
    //初始化TextView
    private TextView getText(){
        TextView textView = new TextView(getContext());
        //设置颜色
        textView.setTextColor(Color.BLACK);
        //设置字体大小
        textView.setTextSize(20);
        textView.setBackgroundResource(R.drawable.text_shape);
        textView.setPadding(10,10,10,10);

        return textView;
    }
}
