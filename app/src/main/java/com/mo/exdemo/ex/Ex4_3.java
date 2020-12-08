package com.mo.exdemo.ex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

/**
 * FileName: Ex4_3
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/9/24-10:12
 * Profile: 返回数据到前一个Activity
 **/
public class Ex4_3 extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton sex_man;
    private RadioButton sex_woman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_3);

        button = findViewById(R.id.button28);
        editText = findViewById(R.id.editText6);
        radioGroup = findViewById(R.id.ex4_3_radioGroup);
        sex_man = findViewById(R.id.ex4_3_RadioButton_sex1);
        sex_woman = findViewById(R.id.ex4_3_RadioButton_sex2);
        initView();
    }

    private void initView() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sex = null;
                String txt = editText.getText().toString();

                radioGroup.isClickable();
                if (sex_man.isChecked()) {
                    sex = sex_man.getText().toString();
                } else if(sex_woman.isChecked()){
                    sex = sex_woman.getText().toString();
                }
                Intent intent = new Intent(Ex4_3.this, Ex4_3_2.class);

                Bundle bundle = new Bundle();
                bundle.putString("text", txt);
                bundle.putString("sex", sex);
                intent.putExtras(bundle);

                /**
                 *  1.修改startActivity()方法为startActivityForResult()
                 *  startActivityForResult(Intent intent,Int requestCode);
                 *  第一个参数为intent对象，第二个参数是一个大于等于0的整数
                 *  将在onActivityResult()函数中用到，用于在onActivityResult()中区分哪个子模块传回的数据。
                 */
                startActivityForResult(intent, 0);
            }
        });
    }

    //2.重写onActivityResult()函数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String returnValue = bundle.getString("returnStr");
                editText.setText(returnValue);
                if (returnValue.contains("男")) {
                    radioGroup.check(R.id.ex4_3_RadioButton_sex1);
                } else if (returnValue.contains("女")) {
                    radioGroup.check(R.id.ex4_3_RadioButton_sex2);
                }
                break;
            default:
                break;
        }
    }
}
