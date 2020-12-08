package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex5_3
 * Package Name: com.mo.exdemo
 * Founder: MoonOrchid
 * Create Date: 2020/9/15-8:55
 * Profile: 单选按钮
 **/
public class Ex5_3 extends AppCompatActivity {

    Button button;
    RadioButton radioButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_3);

        button = findViewById(R.id.button22);
        radioButton = findViewById(R.id.radioButton2);
        textView = findViewById(R.id.textView5);

        //接收丢失的数据
        if (savedInstanceState != null) {
            String s = savedInstanceState.getString("KEY");
            textView.setText(s);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioButton.isChecked()) {
                    textView.setText("回答正确");
                } else {
                    textView.setText("回答错误");
                }
            }
        });
    }

    //保存翻转后丢失的数据
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("KEY", textView.getText().toString());
    }
}
