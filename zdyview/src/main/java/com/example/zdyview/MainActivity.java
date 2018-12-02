package com.example.zdyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.zdyview.View.TitleView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TitleView title_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        title_bar = (TitleView) findViewById(R.id.title_bar);
        title_bar.setOnClickListener(this);
    }

//为自定义标题栏设置点击事件
    @Override
    public void onClick(View v) {

        title_bar.setLeftButtonListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(MainActivity.this,"这是标题栏",Toast.LENGTH_LONG).show();
             finish();
         }
     });
    }
}
