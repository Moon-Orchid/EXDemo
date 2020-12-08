package com.mo.exdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mo.exdemo.ex.*;
import com.mo.exdemo.ex.Ex6_4_ListView.Ex6_4;
import com.mo.exdemo.ex.Ex6_7Tab.Ex6_7;

public class MainActivity extends AppCompatActivity {

    private Button Ex3_2;
    private Button Ex3_3;
    private Button Ex3_4;
    private Button Ex3_5;
    private Button Ex3_6;

    private Button Ex4_1;
    private Button Ex4_2;
    private Button Ex4_3;
    private Button Ex4_4;

    private Button Ex5_1;
    private Button Ex5_2;
    private Button Ex5_3;
    private Button Ex5_4;
    private Button Ex5_5;
    private Button Ex5_6;
    private Button Ex5_7;

    private Button Ex6_1;
    private Button Ex6_2;
    private Button Ex6_3;
    private Button Ex6_4;
    private Button Ex6_5;
    private Button Ex6_6;
    private Button Ex6_7;
    private Button Ex6_8;

    private Button Ex7_1;
    private Button Ex7_2;
    private Button Ex7_3;
    private Button Ex7_4;
    private Button Ex7_5;

    private Button Ex9_1;
    private Button Ex9_2;
    private Button Ex9_3;
    private Button Ex9_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //布局
        Ex3_2 = findViewById(R.id.Ex3_2);
        Ex3_3 = findViewById(R.id.Ex3_3);
        Ex3_4 = findViewById(R.id.Ex3_4);
        Ex3_5 = findViewById(R.id.Ex3_5);
        Ex3_6 = findViewById(R.id.Ex3_6);

        //Activity生命周期
        Ex4_1 = findViewById(R.id.EX4_1);//跳转页面
        Ex4_2 = findViewById(R.id.EX4_2);//传递数据
        Ex4_3 = findViewById(R.id.EX4_3);//向上一个页面返回数据
        Ex4_4 = findViewById(R.id.EX4_4);//Activity生命周期、页面翻转

        //基本控件
        Ex5_1 = findViewById(R.id.EX5_1);//文本控件TextView、EditText
        Ex5_2 = findViewById(R.id.EX5_2);//图片按钮ImageButton
        Ex5_3 = findViewById(R.id.EX5_3);//单选框RadioButton
        Ex5_4 = findViewById(R.id.EX5_4);//复选框CheckBox
        Ex5_5 = findViewById(R.id.EX5_5);//图片控件ImageView
        Ex5_6 = findViewById(R.id.EX5_6);//时钟控件AnalogClock、DigitalClock
        Ex5_7 = findViewById(R.id.EX5_7);//日期/时间控件DatePicker、TimePicker

        //高级控件
        Ex6_1 = findViewById(R.id.EX6_1);//自动完成文本控件AutoCompleteTextView、MultiAutoCompleteTextView
        Ex6_2 = findViewById(R.id.EX6_2);//下拉列表控件(微调框)Spinner
        Ex6_3 = findViewById(R.id.EX6_3);//滚动视图ScrollView
        Ex6_4 = findViewById(R.id.EX6_4);//列表视图ListView
        Ex6_5 = findViewById(R.id.EX6_5);//网格试图GridView
        Ex6_6 = findViewById(R.id.EX6_6);//进度条与滑块ProgressBar、SeekBar
        Ex6_7 = findViewById(R.id.EX6_7);//选项卡TabHost
        Ex6_8 = findViewById(R.id.EX6_8);//画廊控件Gallery

        //菜单与消息提醒
        Ex7_1 = findViewById(R.id.EX7_1);//选项菜单 Menu、菜单项 MenuItem、子菜单 SubMenu
        Ex7_2 = findViewById(R.id.EX7_2);//上下文菜单 ContextMenu
        Ex7_3 = findViewById(R.id.EX7_3);//对话框 Dialog
        Ex7_4 = findViewById(R.id.EX7_4);//Toast消息提示
        Ex7_5 = findViewById(R.id.EX7_5);//状态栏通知 Notification

        //数据存储
        Ex9_3 = findViewById(R.id.EX9_3);//SQLite数据库



        Ex3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex3_2.class);
                //启动
                startActivity(intent);
            }
        });

        Ex3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Ex3_3.class);
                startActivity(intent);
            }
        });

        Ex3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex3_4.class);
                startActivity(intent);
            }
        });

        Ex3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex3_5.class);
                startActivity(intent);
            }
        });
        Ex3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex3_6.class);
                startActivity(intent);
            }
        });

        Ex4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex4_1.class);
                startActivity(intent);
            }
        });
        //TODO:Ex4 Activity生命周期
        Ex4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ex4_2.class);
                startActivity(intent);
            }
        });
        Ex4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ex4_3.class);
                startActivity(intent);
            }
        });
        Ex4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Ex4_4.class);
                startActivity(intent);
            }
        });


        Ex5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_1.class);
                startActivity(intent);
            }
        });
        Ex5_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "文本控件", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        Ex5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_2.class);
                startActivity(intent);
            }
        });
        Ex5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_3.class);
                startActivity(intent);
            }
        });
        Ex5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_4.class);
                startActivity(intent);
            }
        });
        Ex5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_5.class);
                startActivity(intent);
            }
        });
        Ex5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_6.class);
                startActivity(intent);
            }
        });
        Ex5_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex5_7.class);
                startActivity(intent);
            }
        });

        Ex6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_1.class);
                startActivity(intent);
            }
        });

        Ex6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_2.class);
                startActivity(intent);
            }
        });

        Ex6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_3.class);
                startActivity(intent);
            }
        });
        Ex6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_4.class);
                startActivity(intent);
            }
        });
        Ex6_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_5.class);
                startActivity(intent);
            }
        });
        Ex6_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_6.class);
                startActivity(intent);
            }
        });
        Ex6_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_7.class);
                startActivity(intent);
            }
        });
        Ex6_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex6_8.class);
                startActivity(intent);
            }
        });

        Ex7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex7_1.class);
                startActivity(intent);
            }
        });
        Ex7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex7_2.class);
                startActivity(intent);
            }
        });
        Ex7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex7_3.class);
                startActivity(intent);
            }
        });
        Ex7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex7_4.class);
                startActivity(intent);
            }
        });
        Ex7_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex7_5.class);
                startActivity(intent);
            }
        });

        Ex9_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ex9_3.class);
                startActivity(intent);
            }
        });

    }


}
