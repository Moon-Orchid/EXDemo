package com.mo.exdemo.ex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex4_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/24-9:19
 * Profile: 将数据传输到下一个页面
 **/
public class Ex4_2 extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_2);

        editText = findViewById(R.id.enter);
        button = findViewById(R.id.queding);
        initView();

    }

    private void initView() {


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();

                //设置跳转页面
                Intent intent = new Intent(Ex4_2.this, Ex4_2_2.class);

                //设置一个Bundle对象，并将要传送的数据传入
                Bundle bundle = new Bundle();
                //putString(String key,String value)传递的是一个键值对
                bundle.putString("text", text);
                //将bundle对象传递给intent
                intent.putExtras(bundle);

                //打开另一个页面
                startActivity(intent);
            }
        });

    }

}
