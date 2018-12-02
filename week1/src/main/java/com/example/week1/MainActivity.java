package com.example.week1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week1.dao.MyDao;
import com.example.week1.view.FlowView;
import com.example.week1.view.TitleView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String[] data = new String[]{"达利园", "旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥旺旺小小酥", "牛奶面包", "香蕉苹果", "奥利奥", "达利园", "旺旺小小酥", "牛奶面包", "香蕉苹果", "奥利奥", "达利园"};
    private MyDao mDao;
    private ArrayList<String> mList = new ArrayList<>();
    private ArrayList<String> mHistory = new ArrayList<>();
    private TextView mDelete;
    private FlowView MyFloat_Layout;
    private FlowView History_Layout;
    private TitleView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDao = new MyDao(this);
        mHistory = mDao.selectName();
        initData();
        initViews();
        if (!mHistory.isEmpty()) {
        History_Layout.setData(mHistory);
        }
    }


    private void initData() {
        for (int i = 0; i < data.length; i++) {
            mList.add(data[i]);
        }
    }

    private void initViews() {
        mDelete = findViewById(R.id.Delete_Text);
        mDelete.setOnClickListener(this);
        MyFloat_Layout = findViewById(R.id.MyFloat_Layout);
        MyFloat_Layout.setData(mList);
        History_Layout = findViewById(R.id.MyFloat_Layout_History);
        titleView = findViewById(R.id.titleView);
        titleView.getTextView_add().setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add:

                String sname = titleView.getEdit().trim();
              /*  *//*Toast.makeText(MainActivity.this,sname.toString(),Toast.LENGTH_LONG).*//*show();*/
                //自己封装了一个方法删除子控件
                History_Layout.removeChildView();
                mHistory.add(sname);
                mDao.insertSqlite(sname);
                   Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
                History_Layout.setData(mHistory);
                break;
            case R.id.Delete_Text:
                mDao.delete();
                History_Layout.removeChildView();
                break;
        }
    }
}
