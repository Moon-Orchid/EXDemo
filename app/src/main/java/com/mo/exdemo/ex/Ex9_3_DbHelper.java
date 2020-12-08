package com.mo.exdemo.ex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.mo.exdemo.util.LogUtils;

/**
 * FileName: Ex9_3
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/20-10:58
 * Profile: SQLite数据库辅助类，创建数据库、表
 **/
public class Ex9_3_DbHelper extends SQLiteOpenHelper {

    //重写DbHelper的构造参数，回调父函数super
    public Ex9_3_DbHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        //因为要使用SimpleCursorAdapter，要求表的主键为_ID，否则会出现“不存在_ID列”的错误
        db.execSQL("create table if not exists tb_people (" +
                "_id integer primary key autoincrement," +
                "name varchar(20)," +
                "phone varchar(12)," +
                "mobile varchar(12)," +
                "email varchar(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
