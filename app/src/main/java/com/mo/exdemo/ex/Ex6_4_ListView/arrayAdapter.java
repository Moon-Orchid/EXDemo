package com.mo.exdemo.ex.Ex6_4_ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: arrayAdapter
 * Package Name: com.mo.exdemo.ex.Ex6_4_ListView
 * Founder: MoonOrchid
 * Create Date: 2020/9/27-18:27
 * Profile:
 **/
public class arrayAdapter extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private TextView tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arrayadapter);

        listView = findViewById(R.id.arrayList);

        initView();
    }

    private void initView() {

        final String[] weekList = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,weekList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvContent = findViewById(R.id.text0001);
                tvContent.setText("你选择的是："+weekList[position]);
            }
        });
    }
}
