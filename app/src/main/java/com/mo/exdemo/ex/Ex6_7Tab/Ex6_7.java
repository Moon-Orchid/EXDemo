package com.mo.exdemo.ex.Ex6_7Tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_7
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-19:40
 * Profile: TabHost选项卡
 **/
public class Ex6_7 extends AppCompatActivity {


    private Button btn_extendsTabActivity;
    private Button btn_xmlTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_7);

        btn_extendsTabActivity = findViewById(R.id.extendsTabActivity);
        btn_xmlTabHost = findViewById(R.id.xmlTabHost);

        btn_extendsTabActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ex6_7.this, tabActivity.class);
                startActivity(intent);
            }
        });

        btn_xmlTabHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ex6_7.this, tabXml.class);
                startActivity(intent);
            }
        });
    }
}
