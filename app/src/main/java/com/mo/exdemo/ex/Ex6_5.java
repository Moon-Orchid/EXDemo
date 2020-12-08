package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FileName: Ex6_5
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-19:40
 * Profile: GridView网格视图
 **/
public class Ex6_5 extends AppCompatActivity {

    private TextView tv;
    private GridView gridView;
    private List<Map<String, Object>> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_5);

        tv = findViewById(R.id.tv);
        gridView = findViewById(R.id.gridview);

        initView();

    }

    private void initView() {

        //----将图书信息放入HashMap列表中----
        int[] picIDs = {
                R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,
                R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j
        };
        int[] bookIDs = {
                R.string.a, R.string.b, R.string.c, R.string.d, R.string.e,
                R.string.f, R.string.g, R.string.h, R.string.i, R.string.j
        };
        int rowCnt = picIDs.length;
        bookList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < rowCnt; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("picCol", picIDs[i]);
            map.put("bookCol", this.getResources().getString(bookIDs[i]));//获取图书的名字
            bookList.add(map);
        }
        //----END----

        //定义适配器，第二个参数使用bookList列表作为适配器的数据源
        SimpleAdapter ada = new SimpleAdapter(
                this,
                bookList,
                R.layout.griditem,
                new String[]{"picCol", "bookCol"},//定义动态数组
                new int[]{R.id.ItemImage, R.id.ItemText});//定义GridItem对应子项
        //设置适配器
        gridView.setAdapter(ada);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LinearLayout ll_layout = (LinearLayout) view;
                TextView t1 = (TextView) ll_layout.getChildAt(1);
                String str = "您选择的书为：" + t1.getText().toString();
                tv.setText(str);
            }
        });
    }
}
