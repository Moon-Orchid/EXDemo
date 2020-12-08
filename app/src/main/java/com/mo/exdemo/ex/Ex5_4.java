package com.mo.exdemo.ex;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex5_4
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/15-9:24
 * Profile:
 **/
public class Ex5_4 extends AppCompatActivity {

    CheckBox checkBox,checkBox2,checkBox3,checkBox4;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_4);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        textView = findViewById(R.id.textView7);
        button = findViewById(R.id.button23);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "你的爱好有：\n";
                if (checkBox.isChecked()) {
                    s = s + checkBox.getText().toString()+"\n";
                }
                if (checkBox2.isChecked()) {
                    s = s + checkBox2.getText().toString()+"\n";
                }
                if (checkBox3.isChecked()) {
                    s = s + checkBox3.getText().toString()+"\n";
                }
                if (checkBox4.isChecked()) {
                    s = s + checkBox4.getText().toString()+"\n";
                }
                textView.setText(s);

            }
        });
    }
}
