package com.mo.exdemo.ex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex4_3_2
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/27-11:21
 * Profile: 数据返回
 **/
public class Ex4_3_2 extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private Intent intent;
    private Bundle bundle;

    String upText;
    String upSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_3_2);

        button = findViewById(R.id.button27);
        editText = findViewById(R.id.ex4_3_2_text);

        intent = this.getIntent();
        bundle = intent.getExtras();

        upText = bundle.getString("text");
        upSex = bundle.getString("sex");
        editText.setText("上一个页面的数据为：" + upText.replace("上一个页面的数据为：", "").replace(",","") + "，性别为" + upSex);

        initView();
    }

    private void initView() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String returnValue = editText.getText().toString().trim();
                //发送数据
                bundle.putSerializable("returnStr", returnValue);
                intent.putExtras(bundle);
                //返回参数
                Ex4_3_2.this.setResult(RESULT_OK, intent);
                //销毁页面
                Ex4_3_2.this.finish();
            }
        });

    }


}
