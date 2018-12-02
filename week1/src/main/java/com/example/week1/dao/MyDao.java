package com.example.week1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.week1.MainActivity;
import com.example.week1.helper.MyHelper;

import java.util.ArrayList;

public class MyDao {

    private final SQLiteDatabase sd;
    private Context context;

    public MyDao(Context context){
        MyHelper myHelper = new MyHelper(context);
        sd = myHelper.getWritableDatabase();
    }


    //插入
    public void insertSqlite(String name){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        sd.insert("shops", null, contentValues);

    }
    //查询
    public ArrayList<String> selectName(){
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = sd.query("shops", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            String sname = cursor.getString(cursor.getColumnIndex("name"));
            list.add(sname);
        }
        return list;
    }
    //删除
    public void delete(){
        sd.delete("shops",null,null);
    }
}
