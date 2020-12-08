package com.mo.exdemo.ex;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex4_2_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/24-9:30
 * Profile: 获取Ex4_2页面传递过来的数据
 **/
public class Ex4_2_2 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_2_2);

        textView = findViewById(R.id.ex4_2_2_text);

        initView();
    }

    private void initView() {
        //获取Intent中的Bundle对象
        Bundle bundle = this.getIntent().getExtras();
        //获取Bundle对象中的数据
        if (bundle != null) {
            String text = bundle.getString("text");
            if (text.equals("")){
                text = "未输入内容";
            }
            textView.setText("在上一个页面输入了: " + text);
        }

    }
}
