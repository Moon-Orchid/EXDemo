package com.mo.exdemo.ex;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex5_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/15-8:39
 * Profile:
 **/
public class Ex5_2 extends AppCompatActivity {

    Button button1;
    Button button2;
    ImageButton imageButton;

    EditText editText1;
    EditText editText2;
    EditText editText3;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex5_2);

        button1 = findViewById(R.id.button20);
        button2 = findViewById(R.id.button21);
        imageButton = (ImageButton) findViewById(R.id.button3);

        editText1 = findViewById(R.id.editText3);
        editText2 = findViewById(R.id.editText4);
        editText3 = findViewById(R.id.editText5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("消息来自OnClickListener");
            }
        });

    }

    public void Button2Click(View view) {
        editText2.setText("消息来自Button2Click");
    }

    public void ImageButtonClick(View view) {
        editText3.setText("消息来自ImageButton");
    }
}
