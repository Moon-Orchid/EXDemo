package com.mo.exdemo.ex;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mo.exdemo.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * FileName: Ex7_3
 * Package Name: com.mo.exdemo.ex
 * Founder: MoonOrchid
 * Create Date: 2020/10/10-21:24
 * Profile:
 **/
public class Ex7_3 extends AppCompatActivity {

    private Button mEx73Btn1;
    private Button mEx73Btn2;
    private Button mEx73Btn3;
    private Button mEx73Btn4;
    private Button mEx73Btn5;
    private Button mEx73Btn6;
    private Button mEx73Btn7;
    private Button mEx73Btn8;
    private Button mEx73Btn9;
    private TextView mEx73Tv1;
    private EditText mEx73EtName;
    private EditText mEx73EtPwd;

    final private String[]arrayHobby={"篮球","足球","羽毛球","乒乓球"};
    private Dialog alterDialog = null;

    //多选框
    ArrayList<Integer> arrayList = new ArrayList<>();
    final boolean[] initChoiceSets ={false,false,false,false};

    //单选框
    private int yourChoice = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex7_3);


        mEx73Tv1 = (TextView) findViewById(R.id.ex7_3_tv1);
        mEx73Btn1 = (Button) findViewById(R.id.ex7_3_btn1);//普通对话框
        mEx73Btn2 = (Button) findViewById(R.id.ex7_3_btn2);//带按钮的对话框
        mEx73Btn3 = (Button) findViewById(R.id.ex7_3_btn3);//输入对话框
        mEx73Btn4 = (Button) findViewById(R.id.ex7_3_btn4);//列表对话框
        mEx73Btn5 = (Button) findViewById(R.id.ex7_3_btn5);//单选按钮对话框
        mEx73Btn6 = (Button) findViewById(R.id.ex7_3_btn6);//复选框对话框
        mEx73Btn7 = (Button) findViewById(R.id.ex7_3_btn7);//日期时间对话框
        mEx73Btn8 = (Button) findViewById(R.id.ex7_3_btn8);//进度条对话框
        mEx73Btn9 = (Button) findViewById(R.id.ex7_3_btn9);//自定义对话框

        mEx73Btn1.setOnClickListener(new BtClickListener());
        mEx73Btn2.setOnClickListener(new BtClickListener());
        mEx73Btn3.setOnClickListener(new BtClickListener());
        mEx73Btn4.setOnClickListener(new BtClickListener());
        mEx73Btn5.setOnClickListener(new BtClickListener());
        mEx73Btn6.setOnClickListener(new BtClickListener());
        mEx73Btn7.setOnClickListener(new BtClickListener());
        mEx73Btn8.setOnClickListener(new BtClickListener());
        mEx73Btn9.setOnClickListener(new BtClickListener());

    }


    class BtClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ex7_3_btn1:showDialog(1);break;
                case R.id.ex7_3_btn2:showDialog(2);break;
                case R.id.ex7_3_btn3:showDialog(3);break;
                case R.id.ex7_3_btn4:showDialog(4);break;
                case R.id.ex7_3_btn5:showDialog(5);break;
                case R.id.ex7_3_btn6:showDialog(6);break;
                case R.id.ex7_3_btn7:showDialog(7);break;
                case R.id.ex7_3_btn8:showDialog(8);break;
                case R.id.ex7_3_btn9:showDialog(9);break;
            }
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id){
            case 1:
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("普通对话框")
                        .setMessage("这是一个普通对话框")
                        .setIcon(R.drawable.adimg)
                        .create();
                break;
            case 2:
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("确定退出？")
                        .setMessage("您确定要退出程序吗？")
                        .setIcon(R.drawable.adimg)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                break;
            case 3:
                final EditText editText = new EditText(this);
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("请输入")
                        .setIcon(R.drawable.adimg)
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String input = editText.getText().toString().trim();
                                mEx73Tv1.setText(input);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                break;
            case 4:
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("运动列表")
                        .setIcon(R.drawable.adimg)
                        .setItems(arrayHobby, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEx73Tv1.setText("选择了" + arrayHobby[which]);
                            }
                        })
                        .setPositiveButton("确认", null)
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                break;
            case 5:
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("你喜欢哪些运动？")
                        .setIcon(R.drawable.adimg)
                        .setSingleChoiceItems(arrayHobby, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                yourChoice = which;
                            }
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEx73Tv1.setText(arrayHobby[yourChoice]);
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                break;
            case 6:
                arrayList.clear();
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("你喜欢哪些运动？")
                        .setIcon(R.drawable.adimg)
                        .setMultiChoiceItems(arrayHobby, initChoiceSets, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    arrayList.add(which);
                                }else {
                                    arrayList.remove(which);
                                }
                            }
                        })
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder str = new StringBuilder();
                                for (int i = 0; i < arrayList.size(); i++) {
                                    str.append(arrayHobby[arrayList.get(i)]).append(" ");
                                }
                                mEx73Tv1.setText(str.toString());
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                break;
            case 7:
                Calendar mCalendar = Calendar.getInstance();
                alterDialog = new DatePickerDialog(
                        this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                mEx73Tv1.setText(year + "年" + month + "月" + dayOfMonth + "日");
                            }
                        },
                        mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH));
                break;
            case 8:
                /**
                 * @setProgress 设置初始进度
                 * @setProgressStyle 设置样式(水平进度条)
                 * @setMax 设置进度最大值
                 */
                final int MAX_PROGRESS = 100;
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setProgress(0);
                progressDialog.setTitle("下载进度");
                progressDialog.setMax(MAX_PROGRESS);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setCancelable(true);//设置对话框是否可以取消
                progressDialog.show();

                /**
                 * 模拟增加的过程
                 * 新开一个进程，每隔100ms，金进度增加1.
                 */
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while (progress<MAX_PROGRESS) {
                            try {
                                Thread.sleep(100);
                                progress++;
                                progressDialog.setProgress(progress);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        //进度条最大后消失
                        progressDialog.cancel();
                        /**
                         * 在子线程中调用toast会报错Can't toast on a thread that has not called Looper.prepare()
                         * 因为一个线程中没有调用Looper.prepare(),就不能在该线程中创建Toast，这个问题是因为在子线程中弹出Toast导致的。
                         * Android是不能直接在子线程中弹出Toast的
                         *
                         * //解决在子线程中调用Toast的异常情况处理
                         *      Looper.prepare();
                         *          //Toast....
                         *      Looper.loop();
                         * */
                        Looper.prepare();
                        Toast.makeText(Ex7_3.this, "下载完成", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }).start();
                alterDialog = (Dialog) progressDialog;
                break;
            case 9:
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                final View loginView = layoutInflater.inflate(R.layout.login,null);
                alterDialog = new AlertDialog.Builder(this)
                        .setTitle("用户登录")
                        .setIcon(R.drawable.adimg)
                        .setView(loginView)
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mEx73EtName = (EditText) loginView.findViewById(R.id.ex7_3_et_name);
                                mEx73EtPwd = (EditText) loginView.findViewById(R.id.ex7_3_et_pwd);
                                mEx73Tv1.setText("用户名" + mEx73EtName.getText() + "\t密码：" + mEx73EtPwd.getText());
                            }
                        })
                        .setNegativeButton("取消",null)
                        .create();
                break;
        }
        return alterDialog;
    }
}
