package com.mo.exdemo.ex;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;
import com.mo.exdemo.util.LogUtils;

/**
 * FileName: Ex9_3_AddPeopleActivity
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/20-23:00
 * Profile: 对数据进行添加、修改
 **/
public class Ex9_3_AddPeopleActivity extends AppCompatActivity {

    private EditText mEx93EtName;
    private EditText mEx93EtPhone;
    private EditText mEx93EtMobile;
    private EditText mEx93EtEmail;
    private Button mEx93BtSave;
    private Button mEx93BtQuit;

    private String name, phone, mobile, email;

    private Ex9_3_DbHelper dbHelper;
    private SQLiteDatabase database;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex9_3_addpeople);

        mEx93EtName = (EditText) findViewById(R.id.ex9_3_et_name);
        mEx93EtPhone = (EditText) findViewById(R.id.ex9_3_et_phone);
        mEx93EtMobile = (EditText) findViewById(R.id.ex9_3_et_mobile);
        mEx93EtEmail = (EditText) findViewById(R.id.ex9_3_et_email);
        mEx93BtSave = (Button) findViewById(R.id.ex9_3_bt_save);
        mEx93BtQuit = (Button) findViewById(R.id.ex9_3_bt_quit);

        initView();

    }

    private void initView() {
        //获取intent绑定的数据
        final Intent intent = this.getIntent();
        bundle = intent.getExtras();
        if (bundle != null) {
            mEx93EtName.setText(bundle.getString("name"));
            mEx93EtPhone.setText(bundle.getString("phone"));
            mEx93EtMobile.setText(bundle.getString("mobile"));
            mEx93EtEmail.setText(bundle.getString("email"));
        }
        mEx93BtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mEx93EtName.getText().toString();
                phone = mEx93EtPhone.getText().toString();
                mobile = mEx93EtMobile.getText().toString();
                email = mEx93EtEmail.getText().toString();

                //生成一个ContentValues用于存放数据库保存的数据
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("phone", phone);
                values.put("mobile", mobile);
                values.put("email", email);

                //获取数据库的引用后打开数据库
                Ex9_3_DbHelper dbHelper = new Ex9_3_DbHelper(
                        Ex9_3_AddPeopleActivity.this,
                        "Db_People",
                        null,
                        1);
                SQLiteDatabase database = dbHelper.getWritableDatabase();

                long status;
                if (bundle != null) {//若有传输数据,则根据ID修改表中数据
                    LogUtils.i("修改数据");
                    status = database.update(
                            "tb_people",
                            values,
                            "_id=?",
                            new String[]{String.valueOf(bundle.getLong("id"))});
                } else {//若为null,说明没有从上一个Activity传输数据,则插入数据到数据库
                    LogUtils.i("插入数据");
                    status = database.insert(
                            "tb_people",
                            null,
                            values);
                }
                //判断是否保存成功
                if (status != -1) {
                    Toast.makeText(Ex9_3_AddPeopleActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Ex9_3_AddPeopleActivity.this,Ex9_3.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(Ex9_3_AddPeopleActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mEx93BtQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
