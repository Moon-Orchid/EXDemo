package com.mo.exdemo.ex;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex9_3
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/20-11:16
 * Profile: SQLite数据库
 **/
public class Ex9_3 extends AppCompatActivity {

    private ListView peopleList;
    private Ex9_3_DbHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex9_3);

        peopleList = findViewById(R.id.ex9_3_list_people);
        initView();
    }

    private void initView() {
        //创建Db_People数据库
        dbHelper = new Ex9_3_DbHelper(this, "Db_People", null, 1);
        //打开数据库
        database = dbHelper.getReadableDatabase();//只读打开
        //定义游标，查询tb_people表的数据
        Cursor cursor = database.query(
                "tb_people",    //表名
                new String[]{"_id", "name", "phone", "mobile", "email"},//查询列的列表
                null,       //查询条件
                null,   //查询条件参数
                null,       //分组字段
                null,        //格式化为SQL Having子句
                null,       //格式化为一个SQL Order By子句
                "10");         //返回行数


        //遍历cursor中取出的数据
        /*while (cursor.moveToNext()) {
            LogUtils.i("表中的数据1：" + cursor.getString(cursor.getColumnIndex("_id")));
            LogUtils.i("表中的数据2：" + cursor.getString(cursor.getColumnIndex("name")));
            LogUtils.i("表中的数据3：" + cursor.getString(cursor.getColumnIndex("email")));
        }*/

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,
                R.layout.ex9_3_peoplelist,
                cursor,
                new String[]{"_id", "name", "phone", "mobile", "email"},
                new int[]{R.id.ex9_3_id, R.id.ex9_3_name, R.id.ex9_3_phone, R.id.ex9_3_mobile, R.id.ex9_3_email});
        this.peopleList.setAdapter(adapter);//设置适配器
        this.registerForContextMenu(peopleList);//为ListView控件注册上下文菜单
    }


    //创建MENU菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, Menu.FIRST + 1, 1, "添加")
                .setIcon(android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, Menu.FIRST + 2, 2, "退出")
                .setIcon(android.R.drawable.ic_menu_delete);
        return true;
    }

    //增加选项菜单的处理事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST + 1:
                Intent intent = new Intent(Ex9_3.this, Ex9_3_AddPeopleActivity.class);
                startActivity(intent);
                break;
            case Menu.FIRST + 2:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderIcon(R.drawable.adimg);
        menu.add(0, 3, 0, "修改");
        menu.add(0, 4, 0, "删除");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //设置上下文菜单的处理事件
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //获取AdapterContextMenuInfo，来获取选择的ListView项目
        AdapterContextMenuInfo menuInfo = (AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 3:
                //获取所选择的ListView中的Item各值
                String name = ((TextView) menuInfo.targetView.findViewById(R.id.ex9_3_name)).getText().toString();
                String phone = ((TextView) menuInfo.targetView.findViewById(R.id.ex9_3_phone)).getText().toString();
                String mobile = ((TextView) menuInfo.targetView.findViewById(R.id.ex9_3_mobile)).getText().toString();
                String email = ((TextView) menuInfo.targetView.findViewById(R.id.ex9_3_email)).getText().toString();
                //设置跳转页面，并设置数据传输
                Intent intent = new Intent(Ex9_3.this, Ex9_3_AddPeopleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("id", menuInfo.id);//“menuInfo.id” 获取所选择的ListView项目的ID
                bundle.putString("name", name);
                bundle.putString("phone", phone);
                bundle.putString("mobile", mobile);
                bundle.putString("email", email);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case 4:
                dbHelper = new Ex9_3_DbHelper(this, "Db_People", null, 1);
                database = dbHelper.getWritableDatabase();//打开数据库
                database.delete(
                        "tb_people",
                        "_id=?", //查询语句
                        new String[]{String.valueOf(menuInfo.id)});//查询所需参数
                break;
        }
        return true;
    }
}
