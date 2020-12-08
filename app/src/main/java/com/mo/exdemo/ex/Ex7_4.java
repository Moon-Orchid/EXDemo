package com.mo.exdemo.ex;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex7_4
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/11-15:25
 * Profile:
 **/
public class Ex7_4 extends AppCompatActivity {

    private Button mEx74Btn1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex7_4);

        mEx74Btn1 = (Button) findViewById(R.id.ex7_4_btn1);

        initView();

    }

    private void initView() {
        mEx74Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Ex7_4.this, "这是一个Toast提示信息", Toast.LENGTH_SHORT).show();
                Toast toast = Toast.makeText(Ex7_4.this,"这是一个Toast提示信息",Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
