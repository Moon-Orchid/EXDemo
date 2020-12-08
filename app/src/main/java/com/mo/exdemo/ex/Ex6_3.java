package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex6_3
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/22-10:48
 * Profile: ScrollView滚动视图
 **/
public class Ex6_3 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_up;
    private Button btn_down;
    private ScrollView scrollView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex6_3);

        btn_up = findViewById(R.id.UP);
        btn_down = findViewById(R.id.Down);
        scrollView = findViewById(R.id.scrollview);
        textView = findViewById(R.id.textView11);

        btn_up.setOnClickListener(this);
        btn_down.setOnClickListener(this);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 100; i++) {
            stringBuilder.append("这是一条测试文本 * " + i + "\n");
        }
        textView.setText(stringBuilder.toString());


        //设置滑动速度//感觉没什么变化
        scrollView.fling(1/5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {//设置滚动到顶部或底部
            case R.id.UP:
                scrollView.fullScroll(View.FOCUS_UP);
                break;
            case R.id.Down:
                scrollView.fullScroll(View.FOCUS_DOWN);
                break;
        }
    }


}
