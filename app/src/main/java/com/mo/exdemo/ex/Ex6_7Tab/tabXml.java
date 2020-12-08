package com.mo.exdemo.ex.Ex6_7Tab;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: tabXml
 * Package Name: com.mo.exdemo.ex.Ex6_7Tab
 * Founder: MoonOrchid
 * Create Date: 2020/9/23-22:12
 * Profile:
 **/
public class tabXml extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabxml);

        TabHost tabHost = findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost
                .newTabSpec("tab1")
                .setIndicator("第一个",getResources().getDrawable(R.drawable.adimg))
                .setContent(R.id.tab1));
        tabHost.addTab(tabHost
                .newTabSpec("tab2")
                .setIndicator("第二个",getResources().getDrawable(R.drawable.adimg))
                .setContent(R.id.tab2));
        tabHost.addTab(tabHost
                .newTabSpec("tab3")
                .setIndicator("第三个",getResources().getDrawable(R.drawable.adimg))
                .setContent(R.id.tab3));

    }
}
