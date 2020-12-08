package com.mo.exdemo.ex;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex7_4_SecondActity
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/11-15:49
 * Profile:
 **/
public class Ex7_5_SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("这通过文本跳转过来的页面");
        //显示只有一个文本布局的View
        setContentView(tv);
    }
}
