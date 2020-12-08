package com.mo.exdemo.ex.Ex6_4_ListView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_4
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-19:31
 * Profile: 列表视图
 **/
public class Ex6_4 extends AppCompatActivity {

    private Button btn_ArrayAdapter;
    private Button btn_SimpleAdapter;
    private Button btn_SimpleCursorAdapter;

    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_4);

        btn_ArrayAdapter = findViewById(R.id.ex6_4_btn1);
        btn_SimpleAdapter = findViewById(R.id.ex6_4_btn2);
        btn_SimpleCursorAdapter = findViewById(R.id.ex6_4_btn3);

        initView();
    }

    private void initView() {
        btn_ArrayAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Ex6_4.this, arrayAdapter.class);
                startActivity(intent);
            }
        });

        btn_SimpleAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Ex6_4.this, simpleAdapter.class);
                startActivity(intent);
            }
        });

        btn_SimpleCursorAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(Ex6_4.this, simpleCursorAdapter.class);
                startActivity(intent);
            }
        });
    }
}
