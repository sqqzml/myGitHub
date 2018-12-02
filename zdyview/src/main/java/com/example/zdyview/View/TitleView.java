package com.example.zdyview.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zdyview.R;

public class TitleView extends RelativeLayout {

    private  Button btn;
    private TextView title_template;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载布局
        LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        //获取控件
        btn = findViewById(R.id.left_btn);
        title_template = findViewById(R.id.title_template);
    }
    //为左侧按钮添加点击事件
    public void setLeftButtonListener(OnClickListener listener) {
       btn.setOnClickListener(listener);
    }
    //设置标题的方法
    public void setTitle(String title){
        title_template.setText(title);
    }
}
