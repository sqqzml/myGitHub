package com.example.week1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.week1.R;

public class TitleView extends LinearLayout {

    private  EditText edit;
    private  TextView textView_add;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
       LayoutInflater.from(context).inflate(R.layout.title,this);
        edit = findViewById(R.id.Search_Edit);
        textView_add= findViewById(R.id.add);
    }

    public String getEdit() {
        return edit.getText().toString().trim();
    }

    public TextView getTextView_add() {
        return textView_add;
    }
}
